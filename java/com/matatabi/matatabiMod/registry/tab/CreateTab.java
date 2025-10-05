package com.matatabi.matatabiMod.registry.tab;

import com.matatabi.matatabiMod.registry.blcok.MatatabiModBlocks;
import com.matatabi.matatabiMod.registry.item.MatatabiModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class CreateTab {
    public static final Item[] items = {
            Items.STONE_AXE,
            Items.STONE,
            MatatabiModItems.TEST_ITEM.get(),
            MatatabiModBlocks.BlcokItems.TEST_BLOCK.get()
    };
}
