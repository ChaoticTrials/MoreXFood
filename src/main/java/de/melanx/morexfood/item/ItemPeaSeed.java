package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemPeaSeed extends ItemSeeds {
		
	public ItemPeaSeed() {
		super(ModBlocks.cropPea, Blocks.FARMLAND);
		setUnlocalizedName("pea_seed");
		setRegistryName("pea_seed");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "pea_seed");
	}

}