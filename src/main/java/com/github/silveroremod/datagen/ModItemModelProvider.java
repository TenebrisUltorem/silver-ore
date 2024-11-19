package com.github.silveroremod.datagen;

import com.github.silveroremod.SilverOreMod;
import com.github.silveroremod.item.ItemsRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SilverOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ItemsRegistry.RAW_SILVER.get());
        basicItem(ItemsRegistry.SILVER_NUGGET.get());
        basicItem(ItemsRegistry.SILVER_INGOT.get());

        handheldItem(ItemsRegistry.SILVER_AXE);
        handheldItem(ItemsRegistry.SILVER_HOE);
        handheldItem(ItemsRegistry.SILVER_PICKAXE);
        handheldItem(ItemsRegistry.SILVER_SHOVEL);
        handheldItem(ItemsRegistry.SILVER_SWORD);
    }

    private void handheldItem(DeferredItem<?> item) {
        var resourceLocation = ResourceLocation.parse("item/handheld");
        var texture = ResourceLocation.fromNamespaceAndPath(
            SilverOreMod.MOD_ID,"item/" + item.getId().getPath());

        withExistingParent(item.getId().getPath(), resourceLocation).texture("layer0", texture);
    }

}
