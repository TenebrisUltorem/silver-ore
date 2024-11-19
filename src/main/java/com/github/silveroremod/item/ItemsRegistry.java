package com.github.silveroremod.item;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.item.tool.SilverAxe;
import com.github.silveroremod.item.tool.SilverHoe;
import com.github.silveroremod.item.tool.SilverPickaxe;
import com.github.silveroremod.item.tool.SilverShovel;
import com.github.silveroremod.item.tool.SilverSword;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SilverOreMod.MOD_ID);

    public static final DeferredItem<Item> RAW_SILVER = ITEMS.registerSimpleItem("raw_silver");
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot");
    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.registerSimpleItem("silver_nugget");

    public static final DeferredItem<AxeItem> SILVER_AXE = ITEMS.register(
            "silver_axe", SilverAxe::new);
    public static final DeferredItem<HoeItem> SILVER_HOE = ITEMS.register(
            "silver_hoe", SilverHoe::new);
    public static final DeferredItem<PickaxeItem> SILVER_PICKAXE = ITEMS.register(
            "silver_pickaxe", SilverPickaxe::new);
    public static final DeferredItem<ShovelItem> SILVER_SHOVEL = ITEMS.register(
            "silver_shovel", SilverShovel::new);
    public static final DeferredItem<SwordItem> SILVER_SWORD = ITEMS.register(
            "silver_sword", SilverSword::new);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
