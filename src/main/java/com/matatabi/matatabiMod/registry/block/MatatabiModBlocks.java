package com.matatabi.matatabiMod.registry.block;

import com.matatabi.matatabiMod.block.Amethyst_storage;
import com.matatabi.matatabiMod.block.BlueBlock;
import com.matatabi.matatabiMod.block.Press_Machine;
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
        public static final RegistryObject<Block> BLUE_BLOCK = BLOCKS.register("blue_block", BlueBlock::new);

        public static final RegistryObject<Block> PRESS_MACHINE = BLOCKS.register("press_machine", Press_Machine::new);

        public static final RegistryObject<Block> AMETHYST_STORAGE = BLOCKS.register("amethyst_storage", Amethyst_storage::new);

    }

    public static class BlcokItems{
        public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MatatabiMod.MOD_ID);

        public static final RegistryObject<Item> TEST_BLOCK = BLOCK_ITEMS.register("test_block"
                , () -> new BlockItem(Blocks.TEST_BLOCK.get(), new Item.Properties()
                        .stacksTo(64)
                        .rarity(Rarity.EPIC)
                )

                );

        public static final RegistryObject<Item> AMETHYST_STORAGE = BLOCK_ITEMS.register("amethyst_storage"
                , () -> new BlockItem(Blocks.AMETHYST_STORAGE.get(), new Item.Properties()
                        .stacksTo(64)
                        .rarity(Rarity.EPIC)
                )

        );
        public static final RegistryObject<Item> PRESS_MACHINE = BLOCK_ITEMS.register("press_machine"
                , () -> new BlockItem(Blocks.PRESS_MACHINE.get(), new Item.Properties()
                        .stacksTo(64)
                        .rarity(Rarity.EPIC)
                )

        );
        public static final RegistryObject<Item> BLUE_BLOCK = BLOCK_ITEMS.register("blue_block"
                , () -> new BlockItem(Blocks.BLUE_BLOCK.get(), new Item.Properties()
                        .stacksTo(64)
                        .rarity(Rarity.EPIC)
                )

        );


    }
}
