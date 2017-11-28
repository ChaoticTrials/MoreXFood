package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;

public class ItemChickenFricassee extends ItemFood {
	
	public ItemChickenFricassee() {
		super(17, 6.8f, false);
		setUnlocalizedName("chicken_fricassee");
		setRegistryName("chicken_fricassee");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "chicken_fricassee");
	}

}