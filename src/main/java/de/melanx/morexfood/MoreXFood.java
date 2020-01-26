package de.melanx.morexfood;

import de.melanx.morexfood.util.RegisterLoot;
import de.melanx.morexfood.util.Registry;
import de.melanx.morexfood.util.CreativeTab;
import de.melanx.morexfood.util.SeedDrops;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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

        Registry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.SEEDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new SeedDrops());
        MinecraftForge.EVENT_BUS.register(new RegisterLoot());
    }

//		if(ConfigBoolValues.CROP_FIELD.isEnabled()){
//			InitCustomCropField.init();
//		}
//		if(ConfigBoolValues.SALT_ORE_SPAWNING.isEnabled()){
//			GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
//		}
//		ModRecipes.init();

}