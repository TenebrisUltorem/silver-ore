package com.github.silveroremod.block;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.item.ItemsRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlocksRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SilverOreMod.MOD_ID);

    public static final DeferredBlock<Block> SILVER_ORE =
            registerBlock("silver_ore", SilverOre::new);

    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE =
            registerBlock("deepslate_silver_ore", DeepslateSilverOre::new);

    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerBlock(
            "raw_silver_block", RawSilverBlock::new);

    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock(
            "silver_block", SilverBlock::new);


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> blockSupplier) {
        DeferredBlock<T> block = BLOCKS.register(name, blockSupplier);
        ItemsRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
