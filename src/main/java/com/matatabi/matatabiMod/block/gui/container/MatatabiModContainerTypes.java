package com.matatabi.matatabiMod.block.gui.container;

import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MatatabiModContainerTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MatatabiMod.MOD_ID);

    public static final RegistryObject<MenuType<Amethyst_Storage_Menu>> AMETHYST_STORAGE = MENU_TYPES.register("amethyst_storage",()->set(Amethyst_Storage_Menu::new));
    public static final RegistryObject<MenuType<Press_Machine_Menu>> PRESS_MACHINE = MENU_TYPES.register("press_machine",()->set(Press_Machine_Menu::new));

    private static <T extends AbstractContainerMenu> MenuType<T> set(MenuType.MenuSupplier<T> supplier) {
        return new MenuType<>(supplier, FeatureFlags.REGISTRY.allFlags());
    }


}
