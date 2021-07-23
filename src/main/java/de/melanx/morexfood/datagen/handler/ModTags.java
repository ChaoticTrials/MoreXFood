package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.util.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

import javax.annotation.Nullable;

public class ModTags extends ItemTagsProvider {

    public static final Tag.Named<Item> SEEDS = tag(MoreXFood.MODID, "seeds");
    public static final Tag.Named<Item> AGARICUS_SEEDS = tag("seeds_agaricus");
    public static final Tag.Named<Item> ASPARAGUS_SEEDS = tag("seeds_asparagus");
    public static final Tag.Named<Item> PEAS_SEEDS = tag("seeds_peas");
    public static final Tag.Named<Item> RICE_SEEDS = tag("seeds_rice");
    public static final Tag.Named<Item> FOOD = tag("food");

    public ModTags(DataGenerator generator, @Nullable ExistingFileHelper helper) {
        super(generator, new BlockTagsProvider(generator, MoreXFood.MODID, helper), MoreXFood.MODID, helper);
    }

    private static Tag.Named<Item> tag(String name) {
        return ItemTags.bind(new ResourceLocation("forge", name).toString());
    }

    @SuppressWarnings("SameParameterValue")
    private static Tag.Named<Item> tag(String id, String name) {
        return ItemTags.bind(new ResourceLocation(id, name).toString());
    }

    @Override
    protected void addTags() {
        for (RegistryObject<Item> seed : Registry.SEEDS.getEntries()) {
            tag(SEEDS).add(seed.get());
            tag(Tags.Items.SEEDS).add(seed.get());
        }

        tag(AGARICUS_SEEDS).add(Registry.agaricus_seed.get());
        tag(ASPARAGUS_SEEDS).add(Registry.asparagus_seed.get());
        tag(PEAS_SEEDS).add(Registry.peas_seed.get());
        tag(RICE_SEEDS).add(Registry.rice_seed.get());

        for (RegistryObject<Item> food : Registry.FOOD.getEntries())
            tag(FOOD).add(food.get());
        tag(FOOD).add(Items.APPLE, Items.MUSHROOM_STEW, Items.BREAD, Items.PORKCHOP,
                Items.COOKED_PORKCHOP, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE, Items.COD, Items.SALMON,
                Items.TROPICAL_FISH, Items.PUFFERFISH, Items.COOKED_COD, Items.COOKED_SALMON, Items.COOKIE, Items.BEEF,
                Items.COOKED_BEEF, Items.CHICKEN, Items.COOKED_CHICKEN, Items.ROTTEN_FLESH, Items.SPIDER_EYE,
                Items.CARROT, Items.POTATO, Items.BAKED_POTATO, Items.POISONOUS_POTATO, Items.GOLDEN_CARROT,
                Items.PUMPKIN_PIE, Items.RABBIT, Items.COOKED_RABBIT, Items.RABBIT_STEW, Items.MUTTON,
                Items.COOKED_MUTTON, Items.CHORUS_FRUIT, Items.BEETROOT, Items.BEETROOT_SOUP, Items.SUSPICIOUS_STEW,
                Items.SWEET_BERRIES);

        tag(Tags.Items.MUSHROOMS).add(Registry.agaricus.get());
    }
}
