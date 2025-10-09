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
        checkContainerSize(container,105);
        container.startOpen(inventory.player);

        for (int i = 0; i < 7; i++) {
            this.addSlot(new Slot(container, i * 15,5,19+ i*18));
            for (int x = 0; x < 15; x++) {
                this.addSlot(new Slot(container,i* 4 + x + 1,i * 18, 19 + 18 * x));
            }
            
        }
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 9; l++){
                this.addSlot(new Slot(inventory,l + 9 + k * 9,112 + l *18,146 + k * 18));

            }

        }
        for (int m = 0; m < 9; m++) {
            this.addSlot(new Slot(inventory,m,8 + m*18, 204));

        }

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
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.startOpen(player);
    }
}
