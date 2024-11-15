package com.github.silveroremod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class SilverOre extends Block {

    private static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .strength(3.0F, 3.0F)
            .requiresCorrectToolForDrops();

    public SilverOre() {
        super(PROPERTIES);
    }

}
