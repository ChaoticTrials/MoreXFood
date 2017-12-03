package de.melanx.morexfood.drops;

import de.melanx.morexfood.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class GrassDrops {
	
	public static void init() {
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.peasSeed), 10);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.asparagusSeed), 10);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.agaricusSeed), 10);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.riceSeed), 10);
	}

}
