package com.github.silveroremod.datagen;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.block.BlocksRegistry;
import com.github.silveroremod.item.ItemsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlocksRegistry.SILVER_BLOCK.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', ItemsRegistry.SILVER_INGOT)
            .unlockedBy("has_silver_ingot", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemsRegistry.SILVER_INGOT.get(), 9)
            .requires(BlocksRegistry.SILVER_BLOCK)
            .unlockedBy("has_silver_block", has(BlocksRegistry.SILVER_BLOCK))
            .save(pRecipeOutput, SilverOreMod.MOD_ID + ":silver_ingots_from_silver_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.SILVER_INGOT.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', ItemsRegistry.SILVER_NUGGET)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_NUGGET))
            .save(pRecipeOutput, SilverOreMod.MOD_ID + ":silver_ingot_from_silver_nuggets");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemsRegistry.SILVER_NUGGET.get(), 9)
            .requires(ItemsRegistry.SILVER_INGOT)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput);

        List<ItemLike> smeltables = List.of(BlocksRegistry.SILVER_ORE, BlocksRegistry.DEEPSLATE_SILVER_ORE, ItemsRegistry.RAW_SILVER);

        var experience = 0.25F;
        var smeltingTime = 200;
        var blastingTime = 100;
        var groupName = "silver";

        oreSmelting(pRecipeOutput, smeltables, RecipeCategory.MISC, ItemsRegistry.SILVER_INGOT, experience, smeltingTime, groupName);
        oreBlasting(pRecipeOutput, smeltables, RecipeCategory.MISC, ItemsRegistry.SILVER_INGOT, experience, blastingTime, groupName);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsRegistry.SILVER_AXE.get())
            .pattern("## ")
            .pattern("#s ")
            .pattern(" s ")
            .define('#', ItemsRegistry.SILVER_INGOT)
            .define('s', Items.STICK)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput, SilverOreMod.MOD_ID + ":silver_axe_left");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsRegistry.SILVER_AXE.get())
            .pattern(" ##")
            .pattern(" s#")
            .pattern(" s ")
            .define('#', ItemsRegistry.SILVER_INGOT)
            .define('s', Items.STICK)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput, SilverOreMod.MOD_ID + ":silver_axe_right");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsRegistry.SILVER_HOE.get())
            .pattern("## ")
            .pattern(" s ")
            .pattern(" s ")
            .define('#', ItemsRegistry.SILVER_INGOT)
            .define('s', Items.STICK)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput, SilverOreMod.MOD_ID + ":silver_hoe_left");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsRegistry.SILVER_HOE.get())
            .pattern(" ##")
            .pattern(" s ")
            .pattern(" s ")
            .define('#', ItemsRegistry.SILVER_INGOT)
            .define('s', Items.STICK)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput, SilverOreMod.MOD_ID + ":silver_hoe_right");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsRegistry.SILVER_PICKAXE.get())
            .pattern("###")
            .pattern(" s ")
            .pattern(" s ")
            .define('#', ItemsRegistry.SILVER_INGOT)
            .define('s', Items.STICK)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsRegistry.SILVER_SHOVEL.get())
            .pattern(" # ")
            .pattern(" s ")
            .pattern(" s ")
            .define('#', ItemsRegistry.SILVER_INGOT)
            .define('s', Items.STICK)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsRegistry.SILVER_SWORD.get())
            .pattern(" # ")
            .pattern(" # ")
            .pattern(" s ")
            .define('#', ItemsRegistry.SILVER_INGOT)
            .define('s', Items.STICK)
            .unlockedBy("has_silver_nugget", has(ItemsRegistry.SILVER_INGOT))
            .save(pRecipeOutput);
    }
}
