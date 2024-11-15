package com.github.silveroremod.creativemodetabs;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.block.BlocksRegistry;
import com.github.silveroremod.item.ItemsRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeModeTabsRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, SilverOreMod.MOD_ID);

    static {
        CREATIVE_MODE_TAB.register("silver_ore_items_tab", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(BlocksRegistry.SILVER_BLOCK.get()))
                .title(Component.translatable("creativetab.silveroremod.silver_ore_items_tab"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ItemsRegistry.RAW_SILVER);
                    output.accept(ItemsRegistry.SILVER_NUGGET);
                    output.accept(ItemsRegistry.SILVER_INGOT);

                    output.accept(BlocksRegistry.SILVER_ORE);
                    output.accept(BlocksRegistry.DEEPSLATE_SILVER_ORE);
                    output.accept(BlocksRegistry.RAW_SILVER_BLOCK);
                    output.accept(BlocksRegistry.SILVER_BLOCK);
                })
                .build());
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
