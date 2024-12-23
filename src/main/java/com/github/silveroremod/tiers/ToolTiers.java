package com.github.silveroremod.tiers;

import com.github.silveroremod.item.ItemsRegistry;
import com.github.silveroremod.tags.SilverOreBlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ToolTiers {

    public static final Tier SILVER = new SimpleTier(
            SilverOreBlockTags.INCORRECT_FOR_SILVER_TOOL,
            128,
            12.0F,
            1.0F,
            22,
            () -> Ingredient.of(ItemsRegistry.SILVER_INGOT)
    );

}
