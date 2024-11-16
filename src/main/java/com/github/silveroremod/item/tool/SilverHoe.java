package com.github.silveroremod.item.tool;

import com.github.silveroremod.tiers.ToolTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class SilverHoe extends HoeItem {

    private static final Tier TIER = ToolTiers.SILVER;
    private static final Properties PROPERTIES = new Properties()
            .attributes(HoeItem.createAttributes(ToolTiers.SILVER, 0F, -2F));

    public SilverHoe() {
        super(TIER, PROPERTIES);
    }
}
