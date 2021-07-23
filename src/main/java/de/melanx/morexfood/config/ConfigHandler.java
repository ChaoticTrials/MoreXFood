package de.melanx.morexfood.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import de.melanx.morexfood.MoreXFood;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ConfigHandler {

    public static final ForgeConfigSpec COMMON_CONFIG;
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    static {
        init(COMMON_BUILDER);

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static ForgeConfigSpec.BooleanValue seedDrops;
    public static ForgeConfigSpec.DoubleValue seedDropChance;

    public static ForgeConfigSpec.BooleanValue oreGeneration;
    public static ForgeConfigSpec.IntValue saltMinHeight;
    public static ForgeConfigSpec.IntValue saltMaxHeight;
    public static ForgeConfigSpec.IntValue saltVeinsByChunk;

    public static void init(ForgeConfigSpec.Builder builder) {
        seedDrops = builder.comment("If a player breaks grass, mod seeds will be dropped. [default: true]")
                .define("seeds.drops", true);
        seedDropChance = builder.comment("The chance for dropping seeds by breaking grass. [default: 0.05]")
                .defineInRange("seeds.dropChance", 0.05, 0, 1);

        oreGeneration = builder.comment("If set true, ores will be generated [default: true]")
                .define("generation.enabled", true);
        saltMinHeight = builder.comment("Min height where salt ore will be generated [default: 20]")
                .defineInRange("generation.saltOre.minHeight", 20, 0, 255);
        saltMaxHeight = builder.comment("Max height where salt ore will be generated [default: 128]")
                .defineInRange("generation.saltOre.maxHeight", 128, 0, 255);
        saltVeinsByChunk = builder.comment("Max veins by chunk [default: 14]")
                .defineInRange("generation.saltOre.veinsByChunk", 14, 0, Integer.MAX_VALUE);
    }


    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        MoreXFood.LOGGER.debug("Loading config file {}", path);
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }

}
