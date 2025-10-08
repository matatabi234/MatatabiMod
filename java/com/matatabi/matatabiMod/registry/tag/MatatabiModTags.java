package com.matatabi.matatabiMod.registry.tag;

import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MatatabiModTags {




    public static class Blocks{

        public static final TagKey<Block> MATATABI_BLOCKS = tag("matatabi_blocks");

        public static final TagKey<Block> NEEDS_MATATABI_TOOL = tag("needs_matatabi_tool");

        private static TagKey<Block> tag (String name){
            return BlockTags.create(MatatabiMod.makeId(name));
        }
    }

    public static class Items{

        public static final TagKey<Item> MATATABI_ITEMS = tag("matatabi_items");


        private static TagKey<Item> tag (String name){
            return ItemTags.create(MatatabiMod.makeId(name));
        }
    }
}
