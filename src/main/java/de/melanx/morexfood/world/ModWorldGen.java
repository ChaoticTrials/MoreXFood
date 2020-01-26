package de.melanx.morexfood.world;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.util.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModWorldGen {

    public static void init() {
        // TODO config for height, vein size, disable
        MoreXFood.LOGGER.info("Registering ore generation");
        for (Biome biome : Biome.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Registry.salt_ore.get().getDefaultState(), 6),
                    Placement.COUNT_RANGE, new CountRangeConfig(16, 0, 0, 128)));
        }
    }
}