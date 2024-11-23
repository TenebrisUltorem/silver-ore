package com.github.silveroremod.datagen;

import com.github.silveroremod.block.BlocksRegistry;
import com.github.silveroremod.item.ItemsRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(BlocksRegistry.SILVER_BLOCK.get());
        dropSelf(BlocksRegistry.RAW_SILVER_BLOCK.get());

        add(BlocksRegistry.SILVER_ORE.get(),
            block -> createMultipleOreDrop(
                BlocksRegistry.SILVER_ORE.get(),
                ItemsRegistry.RAW_SILVER.get(),
                1, 3)
        );

        add(BlocksRegistry.DEEPSLATE_SILVER_ORE.get(),
            block -> createMultipleOreDrop(
                BlocksRegistry.DEEPSLATE_SILVER_ORE.get(),
                ItemsRegistry.RAW_SILVER.get(),
                1, 3)
        );

        add(BlocksRegistry.SILVER_DOOR.get(), block -> createDoorTable(BlocksRegistry.SILVER_DOOR.get()));
        dropSelf(BlocksRegistry.SILVER_TRAP_DOOR.get());
    }


    protected LootTable.Builder createMultipleOreDrop(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
            this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlocksRegistry.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
