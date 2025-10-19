package com.matatabi.matatabiMod.block.gui.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class Press_Machine_Menu extends AbstractContainerMenu {

    private final Container container;



    public Press_Machine_Menu(int a, Inventory inventory){
        this(a, inventory, new SimpleContainer(3));
    }

    public Press_Machine_Menu(int a , Inventory inventory, Container container) {
        super(MatatabiModContainerTypes.PRESS_MACHINE.get(),a);
        this.container = container;
        container.startOpen(inventory.player);

    }


    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int a) {
        return null;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.startOpen(player);
    }

}
