package de.melanx.morexfood.block;

import java.util.Random;

import javax.annotation.Nullable;

import de.melanx.morexfood.items.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class OreSalt extends BlockBase {
	
	public OreSalt(String name) {
		super(Material.ROCK, name);
		
		setHardness(1.5f);
		setResistance(10.0f);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	@Nullable
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.dustSalt;
	}
	
	@Override
	public int quantityDropped(Random random) {		
		int amount = 2 + random.nextInt(3);		
		return amount;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {		
		if(fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			if(i < 1) {
				i = 1;
			}
			return this.quantityDropped(random) * (i);
		} else {
			return this.quantityDropped(random);
		}		
	}
	
	@Override
	public OreSalt setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}