package com.matatabi.matatabiMod.registry.gui;

import com.matatabi.matatabiMod.block.gui.container.MatatabiModContainerTypes;
import com.matatabi.matatabiMod.block.gui.screen.Amethyst_Storage_Screen;
import com.matatabi.matatabiMod.block.gui.screen.Press_machine_Screen;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MatatabiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        blockScreenRegister();
    }

    private static void blockScreenRegister(){

        MenuScreens.register(MatatabiModContainerTypes.AMETHYST_STORAGE.get(), Amethyst_Storage_Screen::new);
        MenuScreens.register(MatatabiModContainerTypes.PRESS_MACHINE.get(), Press_machine_Screen::new);

    }

}
