package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemAsparagus extends ItemFood {
	
	public ItemAsparagus() {
		super(1, 1.0f, false);
		setUnlocalizedName("asparagus");
		setRegistryName("asparagus");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "asparagus");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("cropAsparagus", this);
	}

}