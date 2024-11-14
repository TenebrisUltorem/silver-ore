package com.github.silveroremod.item;

import com.github.silveroremod.SilverOreMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SilverOreMod.MOD_ID);

    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register(
            "raw_silver", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register(
            "silver_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.register(
            "silver_nugget", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
