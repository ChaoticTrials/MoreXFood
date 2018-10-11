package de.melanx.morexfood.client;

import de.melanx.morexfood.items.ModItems;
import de.melanx.morexfood.morexfood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class morexfoodTab extends CreativeTabs {

	public morexfoodTab() {
		super(morexfood.MODID);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.specialChickenFricassee);
	}

}
