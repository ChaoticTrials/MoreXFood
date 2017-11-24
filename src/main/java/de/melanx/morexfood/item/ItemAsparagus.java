package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemAsparagus extends ItemFood {
	
	public ItemAsparagus() {
		super(3, 0.6f, false);
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