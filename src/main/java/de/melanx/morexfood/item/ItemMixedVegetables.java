package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemMixedVegetables extends ItemFood {
	
	public ItemMixedVegetables() {
		super(3, 0.8f, false);
		setUnlocalizedName("mixed_vegetables");
		setRegistryName("mixed_vegetables");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "mixed_vegetables");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("itemMixedVegatables", this);
	}

}