package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.util.Registry;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;

public class ModTags extends ItemTagsProvider {

    public static final ITag.INamedTag<Item> SEEDS = tag(MoreXFood.MODID, "seeds");
    public static final ITag.INamedTag<Item> AGARICUS_SEEDS = tag("seeds_agaricus");
    public static final ITag.INamedTag<Item> ASPARAGUS_SEEDS = tag("seeds_asparagus");
    public static final ITag.INamedTag<Item> PEAS_SEEDS = tag("seeds_peas");
    public static final ITag.INamedTag<Item> RICE_SEEDS = tag("seeds_rice");
    public static final ITag.INamedTag<Item> FOOD = tag("food");

    public ModTags(DataGenerator generatorIn) {
        super(generatorIn, new BlockTagsProvider(generatorIn));
    }

    private static ITag.INamedTag<Item> tag(String name) {
        return ItemTags.makeWrapperTag(new ResourceLocation("forge", name).toString());
    }

    private static ITag.INamedTag<Item> tag(String id, String name) {
        return ItemTags.makeWrapperTag(new ResourceLocation(id, name).toString());
    }

    @Override
    protected void registerTags() {
        for (RegistryObject<Item> seed : Registry.SEEDS.getEntries())
            func_240522_a_(SEEDS).func_240534_a_(seed.get());

        func_240522_a_(AGARICUS_SEEDS).func_240534_a_(Registry.agaricus_seed.get());
        func_240522_a_(ASPARAGUS_SEEDS).func_240534_a_(Registry.asparagus_seed.get());
        func_240522_a_(PEAS_SEEDS).func_240534_a_(Registry.peas_seed.get());
        func_240522_a_(RICE_SEEDS).func_240534_a_(Registry.rice_seed.get());

        for (RegistryObject<Item> food : Registry.FOOD.getEntries())
            func_240522_a_(FOOD).func_240534_a_(food.get());
        func_240522_a_(FOOD).func_240534_a_(Items.APPLE, Items.MUSHROOM_STEW, Items.BREAD, Items.PORKCHOP,
                Items.COOKED_PORKCHOP, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE, Items.COD, Items.SALMON,
                Items.TROPICAL_FISH, Items.PUFFERFISH, Items.COOKED_COD, Items.COOKED_SALMON, Items.COOKIE, Items.BEEF,
                Items.COOKED_BEEF, Items.CHICKEN, Items.COOKED_CHICKEN, Items.ROTTEN_FLESH, Items.SPIDER_EYE,
                Items.CARROT, Items.POTATO, Items.BAKED_POTATO, Items.POISONOUS_POTATO, Items.GOLDEN_CARROT,
                Items.PUMPKIN_PIE, Items.RABBIT, Items.COOKED_RABBIT, Items.RABBIT_STEW, Items.MUTTON,
                Items.COOKED_MUTTON, Items.CHORUS_FRUIT, Items.BEETROOT, Items.BEETROOT_SOUP, Items.SUSPICIOUS_STEW,
                Items.SWEET_BERRIES);

        func_240522_a_(Tags.Items.MUSHROOMS).func_240534_a_(Registry.agaricus.get());
    }
}
