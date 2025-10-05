package com.matatabi.matatabiMod.item.tool.pickaxe;

import com.matatabi.matatabiMod.item.tool.MatatabiModTiers;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;

public class ToolMatatabiPickaxe extends PickaxeItem {

    public ToolMatatabiPickaxe() {
        super(MatatabiModTiers.MATATABI, 1, -2.8F, new Properties().rarity(Rarity.EPIC).stacksTo(1));
    }
}
