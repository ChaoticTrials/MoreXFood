package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.util.ModRegistration;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, MoreXFood.MODID, helper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : ModRegistration.ITEMS.getEntries()) {
            this.generateItemModel(item.get());
        }
        for (RegistryObject<Item> item : ModRegistration.FOOD.getEntries()) {
            this.generateItemModel(item.get());
        }
        for (RegistryObject<Item> item : ModRegistration.SEEDS.getEntries()) {
            this.generateItemModel(item.get());
        }
        for (RegistryObject<Item> blockItem : ModRegistration.BLOCK_ITEMS.getEntries()) {
            this.generateBlockItemModel(blockItem.get());
        }
    }

    private void generateItemModel(Item item) {
        this.getBuilder(this.getPath(item)).parent(this.getExistingFile(this.mcLoc("item/generated")))
                .texture("layer0", "item/" + this.getPath(item));
    }

    private void generateBlockItemModel(Item item) {
        this.getBuilder(this.getPath(item))
                .parent(new ModelFile.UncheckedModelFile(this.modLoc("block/" + this.getPath(item))));
    }

    private String getPath(Item item) {
        //noinspection ConstantConditions
        return item.getRegistryName().getPath();
    }
}
