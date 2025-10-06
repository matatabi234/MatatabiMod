package com.matatabi.matatabiMod.block;

import com.matatabi.matatabiMod.block.entity.Amethyst_Storage_Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class Amethyst_storage extends BaseEntityBlock {

    public Amethyst_storage() {
        super(Properties.of()
                .strength(5.0F, 10000)
                .lightLevel((a) -> 15)
                .requiresCorrectToolForDrops()
        );
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState blockState, boolean bool) {
        super.onRemove(state, world, pos, blockState, bool);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Amethyst_Storage_Entity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }
}
