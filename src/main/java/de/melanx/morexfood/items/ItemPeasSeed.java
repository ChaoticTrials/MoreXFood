package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemPeasSeed extends ItemSeeds {
		
	public ItemPeasSeed() {
		super(ModBlocks.cropPea, Blocks.FARMLAND);
		setUnlocalizedName("peas_seed");
		setRegistryName("peas_seed");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "peas_seed");
	}

}