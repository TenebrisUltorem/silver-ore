package com.github.silveroremod.block;

import com.github.silveroremod.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.util.List;

public class SilverBlock extends Block {

    private static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.BELL)
            .requiresCorrectToolForDrops()
            .strength(3.0F, 6.0F)
            .sound(SoundType.METAL);

    public SilverBlock() {
        super(PROPERTIES);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (Utils.isUndead(pEntity))
            pEntity.hurt(pLevel.damageSources().generic(), 1.5F);

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            Item.TooltipContext context,
            List<Component> tooltipComponents,
            TooltipFlag tooltipFlag
    ) {
        tooltipComponents.add(Component.translatable("tooltip.silveroremod.deals_damage_to_undead"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
