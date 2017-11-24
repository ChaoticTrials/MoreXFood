package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRice extends ItemFood {
	
	public ItemRice() {
		super(2, 0.6f, false);
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