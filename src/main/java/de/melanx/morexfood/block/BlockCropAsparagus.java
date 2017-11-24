package de.melanx.morexfood.block;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.item.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropAsparagus extends BlockCrops {

	public BlockCropAsparagus() {
		setUnlocalizedName("crop_asparagus");
		setRegistryName("crop_asparagus");
		setCreativeTab(morexfood.creativeTab);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.asparagusSeed;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.asparagus;
	}

}