package com.github.silveroremod.item.tool;

import com.github.silveroremod.tiers.ToolTiers;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class SilverPickaxe extends PickaxeItem {

    private static final Tier TIER = ToolTiers.SILVER;
    private static final Properties PROPERTIES = new Properties()
            .attributes(PickaxeItem.createAttributes(ToolTiers.SILVER, 1, -2.8F));

    public SilverPickaxe() {
        super(TIER, PROPERTIES);
    }
}
