package com.matatabi.matatabiMod.block.entity;

import com.matatabi.matatabiMod.block.gui.container.Amethyst_Storage_Menu;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class Amethyst_Storage_Entity extends RandomizableContainerBlockEntity {

    private NonNullList<ItemStack> items = NonNullList.withSize(105,ItemStack.EMPTY);

    public Amethyst_Storage_Entity(BlockPos pos, BlockState state) {
        super(MatatabiModBlockEntityTypes.AMETHYST_STORAGE.get(),pos,state);

    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, this.items);
    }


    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        ContainerHelper.loadAllItems(nbt, this.items);
    }



    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> list) {
        this.items = list;
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container." + MatatabiMod.MOD_ID + ".amethyst_storage").withStyle(ChatFormatting.GREEN);
    }

    @Override
    protected AbstractContainerMenu createMenu(int a, Inventory inventory) {
        return new Amethyst_Storage_Menu(a, inventory, this);
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return true;
    }
}
