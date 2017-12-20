package de.melanx.morexfood;

import de.melanx.morexfood.block.ModBlocks;
import de.melanx.morexfood.client.morexfoodTab;
import de.melanx.morexfood.items.ModItems;
import de.melanx.morexfood.proxy.CommonProxy;
import de.melanx.morexfood.recipe.ModRecipes;
import de.melanx.morexfood.world.ModWorldGen;
import de.melanx.morexfood.world.village.InitCustomCropField;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = morexfood.MODID, version = "r-1.0", name = "More XFood")

public class morexfood {
	
	public static final String MODID = "morexfood";
	public static final morexfoodTab creativeTab = new morexfoodTab();
	
	@SidedProxy(clientSide = "de.melanx.morexfood.proxy.ClientProxy", serverSide = "de.melanx.morexfood.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ModBlocks.register(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
			ModBlocks.registerItemBlocks(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			ModItems.registerModels();
			ModBlocks.registerModels();
		}
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(MODID + " is loading");
		InitCustomCropField.init();
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModRecipes.init();		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(MODID + " is finished.");		
	}
	
}