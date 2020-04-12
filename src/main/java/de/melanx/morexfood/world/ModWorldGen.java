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
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class ModWorldGen {

    private static final int minHeight = ConfigHandler.saltMinHeight.get();
    private static final int maxHeight = ConfigHandler.saltMaxHeight.get();
    private static final int veinsByChunk = ConfigHandler.saltVeinsByChunk.get();
    private static ConfiguredFeature<?, ?> SALT_FEATURE;

    public static void init() {
        SALT_FEATURE = getFeature(Registry.salt_ore.get(), Feature.ORE);
        MoreXFood.LOGGER.info("Registering ore generation");
        ForgeRegistries.BIOMES.forEach(biome -> {
            if (isValidBiome(biome)) {
                addFeature(biome, SALT_FEATURE);
            }
        });
    }

    private static boolean isValidBiome(Biome biome) {
        return biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND;
    }

    private static void addFeature(Biome biome, @Nullable ConfiguredFeature<?, ?> feature) {
        if (feature != null) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, feature);
        }
    }

    @Nullable
    private static ConfiguredFeature<?, ?> getFeature(Block block, Feature<OreFeatureConfig> feature) {
        return feature.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                block.getDefaultState(), 6)).withPlacement(Placement.COUNT_RANGE.configure(
                new CountRangeConfig(veinsByChunk, minHeight, 0, maxHeight)));
    }
}