package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;

public class ItemRawChickenFricassee extends ItemFood {
		
	public ItemRawChickenFricassee() {
		super(4, 0.0f, false);
		setUnlocalizedName("raw_chicken_fricassee");
		setRegistryName("raw_chicken_fricassee");
		setCreativeTab(morexfood.creativeTab);
	}
		
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "raw_chicken_fricassee");
	}

}