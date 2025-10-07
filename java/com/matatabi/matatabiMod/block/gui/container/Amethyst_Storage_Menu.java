package com.matatabi.matatabiMod.block.gui.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class Amethyst_Storage_Menu extends AbstractContainerMenu {

    private final Container container;

    public Amethyst_Storage_Menu(int a, Inventory inventory){
      this(a, inventory, new SimpleContainer(105));
    }

    public Amethyst_Storage_Menu(int a , Inventory inventory, Container container) {
        super(MatatabiModContainerTypes.AMETHYST_STORAGE.get(),a);
        this.container = container;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int a) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(a);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (a < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }
}
