package de.melanx.morexfood.block;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.items.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropRice extends BlockCrops {

	public BlockCropRice() {
		setUnlocalizedName("crop_rice");
		setRegistryName("crop_rice");
		setCreativeTab(morexfood.creativeTab);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.riceSeed;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.rice;
	}

}