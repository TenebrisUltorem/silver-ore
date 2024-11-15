package com.github.silveroremod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class SilverBlock extends Block {

    private static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.BELL)
            .requiresCorrectToolForDrops()
            .strength(3.0F, 6.0F)
            .sound(SoundType.METAL);

    public SilverBlock() {
        super(PROPERTIES);
    }

}
