package de.melanx.morexfood.world;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.config.ConfigHandler;
import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ModWorldGen {

    private static final int minHeight = ConfigHandler.saltMinHeight.get();
    private static final int maxHeight = ConfigHandler.saltMaxHeight.get();
    private static final int veinsByChunk = ConfigHandler.saltVeinsByChunk.get();
    private static ConfiguredFeature<?, ?> SALT_FEATURE;

    public static void init() {
        SALT_FEATURE = getFeature(Registry.salt_ore.get(), Feature.ORE);
        MoreXFood.LOGGER.info("Registering ore generation");
    }

    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (isValidBiome(event.getCategory())) {
            BiomeGenerationSettingsBuilder generation = event.getGeneration();
            addFeature(generation, SALT_FEATURE);
        }
    }

    private static boolean isValidBiome(Biome.Category biomeCategory) {
        return biomeCategory != Biome.Category.NETHER && biomeCategory != Biome.Category.THEEND;
    }

    private static void addFeature(BiomeGenerationSettingsBuilder generation, @Nullable ConfiguredFeature<?, ?> feature) {
        if (feature != null) {
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, feature);
        }
    }

    @Nonnull
    private static ConfiguredFeature<?, ?> getFeature(Block block, Feature<OreFeatureConfig> feature) {
        return feature.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
                block.getDefaultState(), 6))
                .withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight - minHeight)))
                .func_242728_a()
                .func_242731_b(veinsByChunk);
    }
}