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
    public static ForgeConfigSpec.IntValue seedDropChance;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("config");
        seedDrops = builder.comment("If a player breaks grass, mod seeds will be dropped. [default: true]")
                .define("seedDrops", true);
        seedDropChance = builder.comment("The chance for dropping seeds by breaking grass. 5 = 5% [default: 5]")
                .defineInRange("seedDropChance", 5, 1, 100);
    }


    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        MoreXFood.LOGGER.debug("Loading config file {}", path);

        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

        configData.load();

        spec.setConfig(configData);
    }

}
