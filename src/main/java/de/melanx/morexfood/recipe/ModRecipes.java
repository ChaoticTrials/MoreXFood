package de.melanx.morexfood.recipe;

import de.melanx.morexfood.config.values.ConfigIntValues;
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
		ModItems.dustSalt.initOreDict();
		ModItems.mixedVegetables.initOreDict();
		ModItems.peas.initOreDict();
		ModItems.rawChickenFricassee.initOreDict();
		ModItems.rawChickenFricasseeRice.initOreDict();
		ModItems.rice.initOreDict();
		ModItems.specialChickenFricassee.initOreDict();
		ModItems.specialRawChickenFricassee.initOreDict();
		ModItems.iceCream.initOreDict();
		ModItems.iceCreamBaked.initOreDict();
		ModItems.horseMeat.initOreDict();
		ModItems.rawDogGoulash.initOreDict();
		ModItems.dogGoulash.initOreDict();
		
		// Smelting
		GameRegistry.addSmelting(ModItems.rawChickenFricassee, new ItemStack(ModItems.chickenFricassee), 0);
		GameRegistry.addSmelting(ModItems.rawChickenFricasseeRice, new ItemStack(ModItems.chickenFricasseeRice), 0);
		GameRegistry.addSmelting(ModItems.specialRawChickenFricassee, new ItemStack(ModItems.specialChickenFricassee), 0);
		GameRegistry.addSmelting(ModItems.iceCream, new ItemStack(ModItems.iceCreamBaked), 0);
		GameRegistry.addSmelting(ModItems.horseMeat, new ItemStack(ModItems.lasagne), 0);
		GameRegistry.addSmelting(ModItems.rawDogGoulash, new ItemStack(ModItems.dogGoulash), 0);
	
		// Grass drops
		for(int i = 0; i < ConfigIntValues.PEAS_SEED_DROPPING.getValue(); i++){
			MinecraftForge.addGrassSeed(new ItemStack(ModItems.peasSeed), i);
		}
		for(int i = 0; i < ConfigIntValues.ASPARAGUS_SEED_DROPPING.getValue(); i++){
			MinecraftForge.addGrassSeed(new ItemStack(ModItems.asparagusSeed), i);
		}
		for(int i = 0; i < ConfigIntValues.AGARICUS_SEED_DROPPING.getValue(); i++){
			MinecraftForge.addGrassSeed(new ItemStack(ModItems.agaricusSeed), i);
		}
		for(int i = 0; i < ConfigIntValues.RICE_SEED_DROPPING.getValue(); i++){
			MinecraftForge.addGrassSeed(new ItemStack(ModItems.riceSeed), i);
		}

		
	}

}