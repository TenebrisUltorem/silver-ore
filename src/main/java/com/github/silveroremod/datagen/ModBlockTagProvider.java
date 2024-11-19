package com.github.silveroremod.datagen;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.block.BlocksRegistry;
import com.github.silveroremod.tags.SilverOreBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(
        PackOutput output,
        CompletableFuture<HolderLookup.Provider> lookupProvider,
        @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(output, lookupProvider, SilverOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(BlocksRegistry.SILVER_ORE.get())
            .add(BlocksRegistry.DEEPSLATE_SILVER_ORE.get())
            .add(BlocksRegistry.RAW_SILVER_BLOCK.get())
            .add(BlocksRegistry.SILVER_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
            .add(BlocksRegistry.SILVER_ORE.get())
            .add(BlocksRegistry.DEEPSLATE_SILVER_ORE.get())
            .add(BlocksRegistry.RAW_SILVER_BLOCK.get())
            .add(BlocksRegistry.SILVER_BLOCK.get());

        tag(SilverOreBlockTags.NEEDS_SILVER_TOOL).addTag(BlockTags.NEEDS_STONE_TOOL);
        tag(SilverOreBlockTags.INCORRECT_FOR_SILVER_TOOL)
            .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
            .remove(SilverOreBlockTags.NEEDS_SILVER_TOOL);
    }

}
