package com.github.silveroremod.datagen;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.item.ItemsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(
        PackOutput pOutput,
        CompletableFuture<HolderLookup.Provider> pLookupProvider,
        CompletableFuture<TagLookup<Block>> pBlockTags,
        @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(pOutput, pLookupProvider, pBlockTags, SilverOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.AXES).add(ItemsRegistry.SILVER_AXE.get());
        tag(ItemTags.HOES).add(ItemsRegistry.SILVER_HOE.get());
        tag(ItemTags.PICKAXES).add(ItemsRegistry.SILVER_PICKAXE.get());
        tag(ItemTags.SHOVELS).add(ItemsRegistry.SILVER_SHOVEL.get());
        tag(ItemTags.SWORDS).add(ItemsRegistry.SILVER_SWORD.get());
    }
}
