package com.github.silveroremod.block;

import com.github.silveroremod.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (Utils.isUndead(pEntity))
            pEntity.hurt(pLevel.damageSources().generic(), 0.5F);

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

}
