package de.melanx.morexfood.block;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.items.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropPea extends BlockCrops {

	public BlockCropPea() {
		setUnlocalizedName("crop_pea");
		setRegistryName("crop_pea");
		setCreativeTab(morexfood.creativeTab);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.peasSeed;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.peas;
	}

}