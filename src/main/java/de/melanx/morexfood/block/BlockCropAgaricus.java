package de.melanx.morexfood.block;

import de.melanx.morexfood.morexfood;
import de.melanx.morexfood.items.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropAgaricus extends BlockCrops {

	public BlockCropAgaricus() {
		setUnlocalizedName("crop_agaricus");
		setRegistryName("crop_agaricus");
		setCreativeTab(morexfood.creativeTab);
	}
	
	private static final int MATURE_AGE = 7;
	
	private static final PropertyInteger AGE = PropertyInteger.create("age", 0, MATURE_AGE);
	
	private static final AxisAlignedBB[] CROPS_AABB =
			new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
								new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
										new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
										new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
										new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
										new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
										new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
										new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D)};
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[state.getValue(AGE)];
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.agaricusSeed;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.agaricus;
	}

}