package com.matatabi.matatabiMod.mine; // 👈 パッケージを修正

import com.matatabi.matatabiMod.block.entity.MatatabiModBlockEntityTypes;
import com.matatabi.matatabiMod.block.gui.container.MatatabiModContainerTypes;
import com.matatabi.matatabiMod.registry.block.MatatabiModBlocks;
import com.matatabi.matatabiMod.registry.item.MatatabiModItems;
import com.matatabi.matatabiMod.registry.tab.ModTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("matatabimod")
public class MatatabiMod {
    public static final String MOD_ID = "matatabimod";

    public static ResourceLocation makeId(String path) {
        // 💡 内部でMOD_IDを使っている
        return new ResourceLocation(MOD_ID, path);
    }

    public MatatabiMod(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //Tabの追加
        ModTabs.MOD_TABS.register(bus);
        //アイテムの追加
        MatatabiModItems.ITEM.register(bus);
        //ブロックの追加
        MatatabiModBlocks.Blocks.BLOCKS.register(bus);
        MatatabiModBlocks.BlcokItems.BLOCK_ITEMS.register(bus);
        //ブロックのエンティティタイプの追加
        MatatabiModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        // コンテナタイプ?の追加
        MatatabiModContainerTypes.MENU_TYPES.register(bus);

    }
}
