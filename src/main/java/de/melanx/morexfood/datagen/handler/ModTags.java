package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.util.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;

public class ModTags extends ItemTagsProvider {

    public static final Tag<Item> SEEDS = tag(MoreXFood.MODID, "seeds");
    public static final Tag<Item> AGARICUS_SEEDS = tag("seeds_agaricus");
    public static final Tag<Item> ASPARAGUS_SEEDS = tag("seeds_asparagus");
    public static final Tag<Item> PEAS_SEEDS = tag("seeds_peas");
    public static final Tag<Item> RICE_SEEDS = tag("seeds_rice");
    public static final Tag<Item> FOOD = tag("food");

    public ModTags(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private static Tag<Item> tag(String name) {
        return new ItemTags.Wrapper(new ResourceLocation("forge", name));
    }

    private static Tag<Item> tag(String id, String name) {
        return new ItemTags.Wrapper(new ResourceLocation(MoreXFood.MODID, name));
    }

    @Override
    protected void registerTags() {
        for (RegistryObject<Item> seed : Registry.SEEDS.getEntries())
            getBuilder(SEEDS).add(seed.get());

        getBuilder(AGARICUS_SEEDS).add(Registry.agaricus_seed.get());
        getBuilder(ASPARAGUS_SEEDS).add(Registry.asparagus_seed.get());
        getBuilder(PEAS_SEEDS).add(Registry.peas_seed.get());
        getBuilder(RICE_SEEDS).add(Registry.rice_seed.get());

        for (RegistryObject<Item> food : Registry.FOOD.getEntries())
            getBuilder(FOOD).add(food.get());
        getBuilder(FOOD).add(Items.APPLE).add(Items.MUSHROOM_STEW).add(Items.BREAD).add(Items.PORKCHOP).add(Items.COOKED_PORKCHOP)
                .add(Items.GOLDEN_APPLE).add(Items.ENCHANTED_GOLDEN_APPLE).add(Items.COD).add(Items.SALMON).add(Items.TROPICAL_FISH)
                .add(Items.PUFFERFISH).add(Items.COOKED_COD).add(Items.COOKED_SALMON).add(Items.COOKIE).add(Items.BEEF)
                .add(Items.COOKED_BEEF).add(Items.CHICKEN).add(Items.COOKED_CHICKEN).add(Items.ROTTEN_FLESH).add(Items.SPIDER_EYE)
                .add(Items.CARROT).add(Items.POTATO).add(Items.BAKED_POTATO).add(Items.POISONOUS_POTATO).add(Items.GOLDEN_CARROT)
                .add(Items.PUMPKIN_PIE).add(Items.RABBIT).add(Items.COOKED_RABBIT).add(Items.RABBIT_STEW).add(Items.MUTTON)
                .add(Items.COOKED_MUTTON).add(Items.CHORUS_FRUIT).add(Items.BEETROOT).add(Items.BEETROOT_SOUP).add(Items.SUSPICIOUS_STEW)
                .add(Items.SWEET_BERRIES);

        getBuilder(Tags.Items.MUSHROOMS).add(Registry.agaricus.get());
    }
}
