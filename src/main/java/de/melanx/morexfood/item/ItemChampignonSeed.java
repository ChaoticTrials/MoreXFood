package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemChampignonSeed extends ItemSeeds {
		
	public ItemChampignonSeed() {
		super(ModBlocks.cropChampignon, Blocks.FARMLAND);
		setUnlocalizedName("champignon_seed");
		setRegistryName("champignon_seed");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "champignon_seed");
	}

}