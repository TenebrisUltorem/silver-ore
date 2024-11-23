package com.github.silveroremod.item.tool;

import com.github.silveroremod.tiers.ToolTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class SilverAxe extends AxeItem {

    private static final Tier TIER = ToolTiers.SILVER;
    private static final Properties PROPERTIES = new AxeItem.Properties()
            .attributes(AxeItem.createAttributes(ToolTiers.SILVER, 7F, -3.2F));

    public SilverAxe() {
        super(TIER, PROPERTIES);
    }
}
