package de.melanx.morexfood.world;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.config.ConfigHandler;
import de.melanx.morexfood.util.ModRegistration;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ModWorldGen {

    private static final int MIN_HEIGHT = ConfigHandler.saltMinHeight.get();
    private static final int MAX_HEIGHT = ConfigHandler.saltMaxHeight.get();
    private static final int VEINS_BY_CHUNK = ConfigHandler.saltVeinsByChunk.get();
    private static ConfiguredFeature<?, ?> SALT_FEATURE;

    public static void init() {
        SALT_FEATURE = getFeature(ModRegistration.salt_ore.get(), Feature.ORE);
        MoreXFood.LOGGER.info("Registering ore generation");
    }

    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (isValidBiome(event.getCategory())) {
            BiomeGenerationSettingsBuilder generation = event.getGeneration();
            addFeature(generation, SALT_FEATURE);
        }
    }

    private static boolean isValidBiome(Biome.BiomeCategory biomeCategory) {
        return biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.THEEND;
    }

    private static void addFeature(BiomeGenerationSettingsBuilder generation, @Nullable ConfiguredFeature<?, ?> feature) {
        if (feature != null) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature);
        }
    }

    @SuppressWarnings("SameParameterValue")
    @Nonnull
    private static ConfiguredFeature<?, ?> getFeature(Block block, Feature<OreConfiguration> feature) {
        return feature.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE,
                block.defaultBlockState(), 10))
                .rangeUniform(VerticalAnchor.aboveBottom(MIN_HEIGHT), VerticalAnchor.belowTop(MAX_HEIGHT))
                .squared()
                .count(VEINS_BY_CHUNK);
    }
}
