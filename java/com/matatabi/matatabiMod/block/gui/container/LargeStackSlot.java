package com.matatabi.matatabiMod.block.gui.container;

import com.matatabi.matatabiMod.block.Amethyst_storage;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

// LargeStackSlot.java

public class LargeStackSlot extends Slot {

    // コンストラクタ (これはあなたが提供したものです)
    public LargeStackSlot(Container pContainer, int pIndex, int pX, int pY) {
        super(pContainer, pIndex, pX, pY);
    }

    // 💡 1. このスロットの最大スタック数を宣言 (GUI描画や基本チェックに使用)
    @Override
    public int getMaxStackSize() {
        return 1024;
    }

    // 💡 2. 特定のItemStackに対する最大スタック数を宣言 (最も重要)
    // quickMoveStackやアイテム結合ロジックがこの128個を尊重するために必要です。
    @Override
    public int getMaxStackSize(ItemStack stack) {
        // スロットの制限（128）を強制的に返すことで、アイテム自体の64個の制限を上書きします。
        return 1024;
    }

    // 💡 3. スロットにアイテムを配置できるかチェックする
    // Entity側で return true にしたので、そのロジックに従います。
    @Override
    public boolean mayPlace(ItemStack stack) {
        return this.container.canPlaceItem(this.getSlotIndex(), stack);
    }
}
