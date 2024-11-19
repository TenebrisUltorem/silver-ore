package com.github.silveroremod.datagen;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.block.BlocksRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SilverOreMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlocksRegistry.SILVER_ORE);
        blockWithItem(BlocksRegistry.DEEPSLATE_SILVER_ORE);
        blockWithItem(BlocksRegistry.RAW_SILVER_BLOCK);
        blockWithItem(BlocksRegistry.SILVER_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

}
