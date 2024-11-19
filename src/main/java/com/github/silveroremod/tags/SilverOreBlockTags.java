package com.github.silveroremod.tags;

import com.github.silveroremod.SilverOreMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SilverOreBlockTags {
    public static final TagKey<Block> NEEDS_SILVER_TOOL = createTag("needs_silver_tool");
    public static final TagKey<Block> INCORRECT_FOR_SILVER_TOOL = createTag("incorrect_for_silver_tool");

    private static TagKey<Block> createTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(SilverOreMod.MOD_ID, name));
    }
}
