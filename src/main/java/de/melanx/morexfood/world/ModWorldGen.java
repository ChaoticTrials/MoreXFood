package de.melanx.morexfood.world;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.config.ConfigHandler;
import de.melanx.morexfood.util.ModRegistration;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ModWorldGen {

    private static PlacedFeature SALT_FEATURE;

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

    private static void addFeature(BiomeGenerationSettingsBuilder generation, @Nullable PlacedFeature feature) {
        if (feature != null) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature);
        }
    }

    @SuppressWarnings("SameParameterValue")
    @Nonnull
    private static PlacedFeature getFeature(Block block, Feature<OreConfiguration> feature) {
        return feature.configured(new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES,
                        block.defaultBlockState(), ConfigHandler.veinSize.get()))
                .placed(
                        List.of(
                                CountPlacement.of(40),
                                InSquarePlacement.spread(),
                                HeightRangePlacement.uniform(VerticalAnchor.absolute(ConfigHandler.saltMinHeight.get()),
                                        VerticalAnchor.absolute(ConfigHandler.saltMaxHeight.get())),
                                BiomeFilter.biome()
                        )
                );
    }
}
