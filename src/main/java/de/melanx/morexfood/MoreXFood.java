package de.melanx.morexfood;

import de.melanx.morexfood.config.ConfigHandler;
import de.melanx.morexfood.util.CreativeTab;
import de.melanx.morexfood.util.Events;
import de.melanx.morexfood.util.Registry;
import de.melanx.morexfood.world.ModWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoreXFood.MODID)
public class MoreXFood {

    public static final String MODID = "morexfood";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final CreativeTab creativeTab = new CreativeTab();
    public static MoreXFood instance;

    public MoreXFood() {
        instance = this;

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_CONFIG);
        ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));

        Registry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.FOOD.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.SEEDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(Events.class);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerRenderType);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void registerRenderType(FMLClientSetupEvent event) {
        RenderType cutout = RenderType.getCutout();

        for (RegistryObject<Block> registryObject : Registry.BLOCKS.getEntries()) {
            Block block = registryObject.get();
            if (block instanceof CropsBlock) {
                RenderTypeLookup.setRenderLayer(block, cutout);
            }
        }
    }

    private void setup(FMLCommonSetupEvent event) {
        ModWorldGen.init();
    }
}