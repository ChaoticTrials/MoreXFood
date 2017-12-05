package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemPeas extends ItemFood {
	
	public ItemPeas() {
		super(1, 1.0f, false);
		setUnlocalizedName("peas");
		setRegistryName("peas");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "peas");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("cropPeas", this);
	}

}