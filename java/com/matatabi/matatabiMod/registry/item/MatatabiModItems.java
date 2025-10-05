package com.matatabi.matatabiMod.registry.item;

import com.matatabi.matatabiMod.item.TestItem;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MatatabiModItems {

    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, MatatabiMod.MOD_ID);

    public static final RegistryObject<Item> TEST_ITEM = ITEM.register("test_item", TestItem::new);
}
