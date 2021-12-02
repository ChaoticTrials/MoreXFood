package de.melanx.morexfood;

import de.melanx.morexfood.config.ConfigHandler;
import de.melanx.morexfood.util.CreativeTab;
import de.melanx.morexfood.util.Events;
import de.melanx.morexfood.util.ModRegistration;
import de.melanx.morexfood.world.ModWorldGen;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.RegistryObject;
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

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModRegistration.ITEMS.register(bus);
        ModRegistration.FOOD.register(bus);
        ModRegistration.SEEDS.register(bus);
        ModRegistration.BLOCK_ITEMS.register(bus);
        ModRegistration.BLOCKS.register(bus);
        ModRegistration.LOOT_MODIFIERS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(Events.class);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModWorldGen::onBiomeLoad);
        bus.addListener(this::registerRenderType);
        bus.addListener(this::setup);
    }

    private void registerRenderType(FMLClientSetupEvent event) {
        RenderType cutout = RenderType.cutout();

        for (RegistryObject<Block> registryObject : ModRegistration.BLOCKS.getEntries()) {
            Block block = registryObject.get();
            if (block instanceof CropBlock) {
                ItemBlockRenderTypes.setRenderLayer(block, cutout);
            }
        }
    }

    private void setup(FMLCommonSetupEvent event) {
        ModWorldGen.init();
    }
}
