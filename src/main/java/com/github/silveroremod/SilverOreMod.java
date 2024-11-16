package com.github.silveroremod;

import com.github.silveroremod.block.BlocksRegistry;
import com.github.silveroremod.creativemodetabs.CreativeModeTabsRegistry;
import com.github.silveroremod.item.ItemsRegistry;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(SilverOreMod.MOD_ID)
public class SilverOreMod {

    public static final String MOD_ID = "silveroremod";

    public SilverOreMod(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        CreativeModeTabsRegistry.register(modEventBus);
        BlocksRegistry.register(modEventBus);
        ItemsRegistry.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemsRegistry.RAW_SILVER);
            event.accept(ItemsRegistry.SILVER_INGOT);
            event.accept(ItemsRegistry.SILVER_NUGGET);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemsRegistry.SILVER_AXE);
            event.accept(ItemsRegistry.SILVER_HOE);
            event.accept(ItemsRegistry.SILVER_PICKAXE);
            event.accept(ItemsRegistry.SILVER_SHOVEL);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ItemsRegistry.SILVER_SWORD);
            event.accept(ItemsRegistry.SILVER_AXE);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BlocksRegistry.SILVER_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlocksRegistry.SILVER_ORE);
            event.accept(BlocksRegistry.DEEPSLATE_SILVER_ORE);
            event.accept(BlocksRegistry.RAW_SILVER_BLOCK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
