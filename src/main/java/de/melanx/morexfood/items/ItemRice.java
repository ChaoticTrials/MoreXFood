package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRice extends ItemFood {
	
	public ItemRice() {
		super(1, 1.0f, false);
		setUnlocalizedName("rice");
		setRegistryName("rice");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "rice");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("cropRice", this);
	}

}