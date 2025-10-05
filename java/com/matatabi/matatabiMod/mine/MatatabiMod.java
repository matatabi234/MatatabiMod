package com.matatabi.matatabiMod.mine; // 👈 パッケージを修正

import com.matatabi.matatabiMod.registry.blcok.MatatabiModBlocks;
import com.matatabi.matatabiMod.registry.item.MatatabiModItems;
import com.matatabi.matatabiMod.registry.tab.ModTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("matatabimod")
public class MatatabiMod {
    public static final String MOD_ID = "matatabimod";

    public MatatabiMod(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //Tabの追加
        ModTabs.MOD_TABS.register(bus);
        //アイテムの追加
        MatatabiModItems.ITEM.register(bus);
        //ブロックの追加
        MatatabiModBlocks.Blocks.BLOCKS.register(bus);
        MatatabiModBlocks.BlcokItems.BLOCK_ITEMS.register(bus);

    }
}
