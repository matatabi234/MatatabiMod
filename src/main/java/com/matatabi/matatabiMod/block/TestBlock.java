package com.matatabi.matatabiMod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class TestBlock extends Block {

    public TestBlock() {
        super(Properties.of()
                .strength(5.0F, 10000)
                .sound(SoundType.ANVIL)
                .lightLevel((a) -> 15)
                .requiresCorrectToolForDrops()

        );
    }
}
