package com.matatabi.matatabiMod.registry.blcok;

import com.matatabi.matatabiMod.block.TestBlock;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MatatabiModBlocks {

    public static class Blocks{

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MatatabiMod.MOD_ID);

        public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block",TestBlock::new);

    }

    public static class BlcokItems{
        public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MatatabiMod.MOD_ID);

        public static final RegistryObject<Item> TEST_BLOCK = BLOCK_ITEMS.register("test_block"
                , () -> new BlockItem(Blocks.TEST_BLOCK.get(), new Item.Properties()
                        .stacksTo(64))

                );
    }
}
