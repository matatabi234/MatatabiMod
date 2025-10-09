package com.matatabi.matatabiMod.block;

import com.matatabi.matatabiMod.block.entity.Amethyst_Storage_Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
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
        Amethyst_Storage_Entity entity = (Amethyst_Storage_Entity)te;

        super.onRemove(state, world, pos, blockState, bool);
        Containers.dropContents(world,pos,entity);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Amethyst_Storage_Entity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
