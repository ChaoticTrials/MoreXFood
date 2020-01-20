package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.util.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.fml.RegistryObject;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, MoreXFood.MODID, helper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : Registry.ITEMS.getEntries()) {
            generateItemModel(item.get());
        }
        for (RegistryObject<Item> blockItem : Registry.BLOCK_ITEMS.getEntries()) {
            generateBlockItemModel(blockItem.get());
        }
    }

    private void generateItemModel(Item item) {
        getBuilder(getPath(item)).parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + getPath(item));
    }

    private void generateBlockItemModel(Item item) {
        getBuilder(getPath(item))
                .parent(new ModelFile.UncheckedModelFile(modLoc("block/" + getPath(item))));
    }

    @Override
    public String getName() {
        return "Item Models";
    }

    private String getPath(Item item) {
        return item.getRegistryName().getPath();
    }
}
