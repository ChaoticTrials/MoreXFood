package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemAsparagusSeed extends ItemSeeds {
		
	public ItemAsparagusSeed() {
		super(ModBlocks.cropAsparagus, Blocks.FARMLAND);
		setUnlocalizedName("asparagus_seed");
		setRegistryName("asparagus_seed");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "asparagus_seed");
	}

}