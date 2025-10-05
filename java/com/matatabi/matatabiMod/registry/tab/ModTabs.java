package com.matatabi.matatabiMod.registry.tab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import com.matatabi.matatabiMod.mine.MatatabiMod;

public class ModTabs {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MatatabiMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> Matatabi_Mod_Tab = MOD_TABS.register("matatabitab",
                    ()-> CreativeModeTab.builder()
                                .icon(() -> new ItemStack(Blocks.STONE))
                                .title(Component.translatable("itemGroup.matatabi_mod"))
                                .displayItems((param,output)->{
                                    for (Item item:CreateTab.items){
                                        output.accept(item);
                                    }
                                })
                                .build()
    );
}
