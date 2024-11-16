package com.github.silveroremod.item.tool;

import com.github.silveroremod.tiers.ToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SilverSword extends SwordItem {

    private static final Tier TIER = ToolTiers.SILVER;
    private static final Item.Properties PROPERTIES = new Item.Properties()
            .attributes(SwordItem.createAttributes(ToolTiers.SILVER, 3, -2.4F));

    public SilverSword() {
        super(TIER, PROPERTIES);
    }
}
