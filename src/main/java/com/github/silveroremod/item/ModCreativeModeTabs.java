package com.github.silveroremod.item;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, SilverOreMod.MOD_ID);

    static {
        CREATIVE_MODE_TAB.register("silver_ore_items_tab", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(ModBlocks.SILVER_BLOCK.get()))
                .title(Component.translatable("creativetab.silveroremod.silver_ore_items_tab"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ModItems.RAW_SILVER);
                    output.accept(ModItems.SILVER_NUGGET);
                    output.accept(ModItems.SILVER_INGOT);

                    output.accept(ModBlocks.SILVER_ORE);
                    output.accept(ModBlocks.DEEPSLATE_SILVER_ORE);
                    output.accept(ModBlocks.RAW_SILVER_BLOCK);
                    output.accept(ModBlocks.SILVER_BLOCK);
                })
                .build());
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
