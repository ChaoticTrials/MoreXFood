package de.melanx.morexfood.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	
	public static BlockCropPea cropPea = new BlockCropPea();
	public static BlockCropAsparagus cropAsparagus = new BlockCropAsparagus();
	public static BlockCropAgaricus cropAgaricus = new BlockCropAgaricus();
	public static BlockCropRice cropRice = new BlockCropRice();
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				cropPea,
				cropAsparagus,
				cropAgaricus,
				cropRice
		);
		
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		
	}
	
	public static void registerModels() {
		
	}

}