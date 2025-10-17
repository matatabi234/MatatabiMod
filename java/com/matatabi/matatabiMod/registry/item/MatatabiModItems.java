package com.matatabi.matatabiMod.registry.item;

import com.matatabi.matatabiMod.item.BlueIngot;
import com.matatabi.matatabiMod.item.BlueStone;
import com.matatabi.matatabiMod.item.TestItem;
import com.matatabi.matatabiMod.item.tool.pickaxe.ToolMatatabiPickaxe;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MatatabiModItems {

    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, MatatabiMod.MOD_ID);

    public static final RegistryObject<Item> TEST_ITEM = ITEM.register("test_item", TestItem::new);
    public static final RegistryObject<Item> BLUE_STONE = ITEM.register("blue_stone", BlueStone::new);
    public static final RegistryObject<Item> BLUE_INGOT = ITEM.register("blue_ingot", BlueIngot::new);


    public static final RegistryObject<PickaxeItem> MATATABI_PICKAXE = ITEM.register("matatabi_pickaxe", ToolMatatabiPickaxe::new);
}
