package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemAgaricusSeed extends ItemSeeds {
		
	public ItemAgaricusSeed() {
		super(ModBlocks.cropAgaricus, Blocks.FARMLAND);
		setUnlocalizedName("agaricus_seed");
		setRegistryName("agaricus_seed");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "agaricus_seed");
	}

}