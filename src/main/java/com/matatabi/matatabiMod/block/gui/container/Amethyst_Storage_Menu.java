package com.matatabi.matatabiMod.block.gui.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class Amethyst_Storage_Menu extends AbstractContainerMenu {

    private final Container container;



    public Amethyst_Storage_Menu(int a, Inventory inventory){
      this(a, inventory, new SimpleContainer(105));
    }

    public Amethyst_Storage_Menu(int a , Inventory inventory, Container container) {
        super(MatatabiModContainerTypes.AMETHYST_STORAGE.get(),a);
        this.container = container;
//        checkContainerSize(container,105);
        container.startOpen(inventory.player);

// 座標はGUIテクスチャに合わせて調整してください
        final int START_X = 4;   // スロットの開始X座標 (例として9を使用)
        final int START_Y = 18;  // スロットの開始Y座標 (例として18を使用)

        int slotnumber = 0;
// 7行のループ (row: Y座標の制御、外側)
        for (int row = 0; row < 7; row++) {
            // 15列のループ (col: X座標の制御、内側)
            for (int col = 0; col < 15; col++) {

                // 1. スロットインデックス (横優先): (行番号 * 15) + 列番号
                slotnumber = (row * 15) + col;

                // 2. X座標の計算 (列にのみ依存)
                int x = START_X + col * 18;

                // 3. Y座標の計算 (行にのみ依存)
                int y = START_Y + row * 18;

//                this.addSlot(new Slot(container, slotnumber, x, y));
                this.addSlot(new LargeStackSlot(container, slotnumber, x, y));
            }
        }

        int playerInvX = 112; // プレイヤーインベントリの開始X座標
        int playerInvY = 146; // プレイヤーインベントリのメイン部分の開始Y座標

        for (int k = 0; k < 3; k++) { // 3行
            for (int l = 0; l < 9; l++) { // 9列
                // スロットインデックス: 9 + l + k * 9 (9, 10, ..., 35)
                this.addSlot(new Slot(inventory, l + 9 + k * 9, playerInvX + l * 18, playerInvY + k * 18));
            }
        }

        // プレイヤーインベントリのホットバー (インデックス 0〜8)
        // メインインベントリの下に配置すると仮定
        int hotbarY = playerInvY + 58; // メインインベントリの下に少しスペースを空ける

        for (int m = 0; m < 9; m++) {
            // スロットインデックス: m (0, 1, ..., 8)
            this.addSlot(new Slot(inventory, m, playerInvX + m * 18, hotbarY));
        }

    }


    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.startOpen(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int a) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(a);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (a < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    protected boolean moveItemStackTo(ItemStack stack, int startIndex, int endIndex, boolean reverse) {
        boolean didSomething = false;
        int i = startIndex;

        if (reverse) {
            i = endIndex - 1;
        }

        while (!stack.isEmpty()) {
            if (reverse) {
                if (i < startIndex) break;
            } else {
                if (i >= endIndex) break;
            }

            Slot slot = this.slots.get(i);
            ItemStack slotStack = slot.getItem();

            // アイテムの種類とNBTタグが完全に一致するかをチェック
            if (!slotStack.isEmpty() && ItemStack.isSameItemSameTags(stack, slotStack)) {
                int combinedCount = slotStack.getCount() + stack.getCount();

                // 💡 128個を尊重: スロットが許容する最大サイズを使用
                int maxSize = slot.getMaxStackSize(slotStack);

                if (combinedCount <= maxSize) {
                    stack.setCount(0);
                    slotStack.setCount(combinedCount);
                    slot.setChanged();
                    didSomething = true;
                } else if (slotStack.getCount() < maxSize) {
                    stack.shrink(maxSize - slotStack.getCount());
                    slotStack.setCount(maxSize);
                    slot.setChanged();
                    didSomething = true;
                }
            }

            i += reverse ? -1 : 1;
        }

        // 空のスロットに挿入
        if (!stack.isEmpty()) {
            if (reverse) i = endIndex - 1;
            else i = startIndex;

            while (true) {
                if (reverse) {
                    if (i < startIndex) break;
                } else {
                    if (i >= endIndex) break;
                }

                Slot slot = this.slots.get(i);
                ItemStack itemstack1 = slot.getItem();

                if (itemstack1.isEmpty() && slot.mayPlace(stack)) {

                    // 💡 128個を尊重
                    if (stack.getCount() > slot.getMaxStackSize(stack)) {
                        slot.set(stack.split(slot.getMaxStackSize(stack)));
                    } else {
                        slot.set(stack.split(stack.getCount()));
                    }

                    slot.setChanged();
                    didSomething = true;
                    break;
                }

                i += reverse ? -1 : 1;
            }
        }

        return didSomething;
    }
}
