package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemPea extends ItemFood {
	
	public ItemPea() {
		super(2, 0.6f, false);
		setUnlocalizedName("pea");
		setRegistryName("pea");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "pea");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("cropPea", this);
	}

}