package com.github.silveroremod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class DeepslateSilverOre extends Block {

    private static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .strength(4.5F, 3.0F)
            .requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE);

    public DeepslateSilverOre() {
        super(PROPERTIES);
    }

}
