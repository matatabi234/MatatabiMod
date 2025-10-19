package com.matatabi.matatabiMod.block.entity;

import com.matatabi.matatabiMod.mine.MatatabiMod;
import com.matatabi.matatabiMod.registry.block.MatatabiModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MatatabiModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MatatabiMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<Amethyst_Storage_Entity>> AMETHYST_STORAGE = BLOCK_ENTITY_TYPES.register("amethyst_storage",()->set(Amethyst_Storage_Entity::new, MatatabiModBlocks.Blocks.AMETHYST_STORAGE.get()));
    public static final RegistryObject<BlockEntityType<Press_Machine_Entity>> PRESS_MACHINE = BLOCK_ENTITY_TYPES.register("press_machine",()->set(Press_Machine_Entity::new, MatatabiModBlocks.Blocks.PRESS_MACHINE.get()));

    private static <T extends BlockEntity> BlockEntityType<T> set (BlockEntityType.BlockEntitySupplier<T> entity, Block block) {
      return BlockEntityType.Builder.of(entity, block).build(null);
    };

}
