package com.matatabi.matatabiMod.block;

import com.matatabi.matatabiMod.block.entity.Press_Machine_Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class Press_Machine extends BaseEntityBlock {
    public Press_Machine() {
        super(Properties.of()
                .strength(5.0F, 10000)
                .sound(SoundType.ANVIL)
                .lightLevel((a) -> 15)
                .requiresCorrectToolForDrops()
                .noOcclusion()

        );
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player.isSteppingCarefully()){

        }else {
            if (!world.isClientSide){
                MenuProvider provider = this.getMenuProvider(state,world,pos);
                player.openMenu(provider);
            }
        }

        return InteractionResult.SUCCESS;

    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState blockState, boolean bool) {
        BlockEntity te = world.getBlockEntity(pos);
        Press_Machine_Entity entity = (Press_Machine_Entity) te;

        super.onRemove(state, world, pos, blockState, bool);
        Containers.dropContents(world,pos,entity);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Press_Machine_Entity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
