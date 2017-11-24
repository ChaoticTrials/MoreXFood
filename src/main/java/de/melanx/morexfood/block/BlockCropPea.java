package de.melanx.morexfood.block;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.item.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropPea extends BlockCrops {

	public BlockCropPea() {
		setUnlocalizedName("crop_pea");
		setRegistryName("crop_pea");
		setCreativeTab(morexfood.creativeTab);
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.peaSeed;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.pea;
	}

}
