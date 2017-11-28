package de.melanx.morexfood.client;

import de.melanx.morexfood.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class morexfoodTab extends CreativeTabs {

	private static final String modID = "More XFood";

	public morexfoodTab() {
		super(morexfoodTab.modID);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.peas);
	}

}
