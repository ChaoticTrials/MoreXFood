package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemChampignon extends ItemFood {
	
	public ItemChampignon() {
		super(1, 0.6f, false);
		setUnlocalizedName("champignon");
		setRegistryName("champignon");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "champignon");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("cropChampignon", this);
	}

}