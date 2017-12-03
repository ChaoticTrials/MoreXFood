package de.melanx.morexfood.recipe;

import de.melanx.morexfood.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {
		
		// Ore Dict
		ModItems.agaricus.initOreDict();
		ModItems.asparagus.initOreDict();
		ModItems.asparagusPieces.initOreDict();
		ModItems.carrotPieces.initOreDict();
		ModItems.chickenFricassee.initOreDict();
		ModItems.chickenFricasseeRice.initOreDict();
		ModItems.chickenPieces.initOreDict();
		ModItems.mixedVegetables.initOreDict();
		ModItems.peas.initOreDict();
		ModItems.rawChickenFricassee.initOreDict();
		ModItems.rawChickenFricasseeRice.initOreDict();
		ModItems.rice.initOreDict();
		ModItems.specialChickenFricassee.initOreDict();
		ModItems.specialRawChickenFricassee.initOreDict();
		
		// Smelting
		GameRegistry.addSmelting(ModItems.rawChickenFricassee, new ItemStack(ModItems.chickenFricassee), 0);
		GameRegistry.addSmelting(ModItems.rawChickenFricasseeRice, new ItemStack(ModItems.chickenFricasseeRice), 0);
		GameRegistry.addSmelting(ModItems.specialRawChickenFricassee, new ItemStack(ModItems.specialChickenFricassee), 0);
	
		// Grass drops
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.peasSeed), 10);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.asparagusSeed), 10);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.agaricusSeed), 10);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.riceSeed), 10);
		
	}

}