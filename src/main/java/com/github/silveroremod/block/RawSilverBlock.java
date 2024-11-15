package com.github.silveroremod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RawSilverBlock extends Block {

    private static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .strength(5F, 6F)
            .requiresCorrectToolForDrops();

    public RawSilverBlock() {
        super(PROPERTIES);
    }

}
