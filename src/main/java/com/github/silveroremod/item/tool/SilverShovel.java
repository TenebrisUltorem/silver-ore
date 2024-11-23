package com.github.silveroremod.item.tool;

import com.github.silveroremod.tiers.ToolTiers;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class SilverShovel extends ShovelItem {

    private static final Tier TIER = ToolTiers.SILVER;
    private static final Properties PROPERTIES = new ShovelItem.Properties()
            .attributes(ShovelItem.createAttributes(ToolTiers.SILVER, 1.5F, -3F));

    public SilverShovel() {
        super(TIER, PROPERTIES);
    }
}
