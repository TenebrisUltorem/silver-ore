package com.github.silveroremod.block;

import com.github.silveroremod.utils.Constants;
import com.github.silveroremod.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.List;

public class SilverTrapDoor extends TrapDoorBlock {

    private static final Properties PROPERTIES = BlockBehaviour.Properties.of()
        .requiresCorrectToolForDrops()
        .strength(2.0F)
        .noOcclusion();

    public SilverTrapDoor() {
        super(BlockSetType.COPPER, PROPERTIES);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (Utils.isUndead(pEntity)) pEntity.hurt(pLevel.damageSources().magic(), Constants.SILVER_BLOCKS_DAMAGE);
    }

    @Override
    protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (Utils.isUndead(pEntity)) pEntity.hurt(pLevel.damageSources().magic(), Constants.SILVER_BLOCKS_DAMAGE);
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
