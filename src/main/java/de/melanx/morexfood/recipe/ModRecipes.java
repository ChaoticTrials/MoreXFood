package de.melanx.morexfood.recipe;

import de.melanx.morexfood.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {
		GameRegistry.addSmelting(ModItems.rawChickenFricassee, new ItemStack(ModItems.chickenFricassee), 0);
		GameRegistry.addSmelting(ModItems.rawChickenFricasseeRice, new ItemStack(ModItems.chickenFricasseeRice), 0);
		GameRegistry.addSmelting(ModItems.specialRawChickenFricassee, new ItemStack(ModItems.specialChickenFricassee), 0);
	}

}