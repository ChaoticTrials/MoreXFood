package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemRiceSeed extends ItemSeeds {
		
	public ItemRiceSeed() {
		super(ModBlocks.cropRice, Blocks.FARMLAND);
		setUnlocalizedName("rice_seed");
		setRegistryName("rice_seed");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "rice_seed");
	}

}