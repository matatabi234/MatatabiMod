package com.matatabi.matatabiMod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class Amethyst_Storage_Entity extends BlockEntity {
    public Amethyst_Storage_Entity(BlockPos pos, BlockState state) {
        super(MatatabiModBlockEntityTypes.AMETHYST_STORAGE.get(),pos,state);

    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
    }
}
