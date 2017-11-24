package de.melanx.morexfood.block;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.item.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropChampignon extends BlockCrops {

	public BlockCropChampignon() {
		setUnlocalizedName("crop_champignon");
		setRegistryName("crop_champignon");
		setCreativeTab(morexfood.creativeTab);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.champignonSeed;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.champignon;
	}

}