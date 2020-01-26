package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.util.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
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

        getBuilder(Tags.Items.MUSHROOMS).add(Registry.agaricus.get());
    }
}
