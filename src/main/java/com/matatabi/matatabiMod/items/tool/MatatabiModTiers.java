package com.matatabi.matatabiMod.items.tool;

import com.matatabi.matatabiMod.mine.MatatabiMod;
import com.matatabi.matatabiMod.registry.item.MatatabiModItems;
import com.matatabi.matatabiMod.registry.tag.MatatabiModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class MatatabiModTiers {

    public static final ForgeTier MATATABI =new ForgeTier(8,9000,200F,20000000F
            ,3, MatatabiModTags.Blocks.NEEDS_MATATABI_TOOL, () -> Ingredient.of(MatatabiModItems.TEST_ITEM.get()));

    static {
        TierSortingRegistry.registerTier(MATATABI, MatatabiMod.makeId("matatabi"),
                List.of(Tiers.NETHERITE), List.of());
    }
}
