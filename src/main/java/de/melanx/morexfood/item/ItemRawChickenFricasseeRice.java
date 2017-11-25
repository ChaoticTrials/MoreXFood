package de.melanx.morexfood.item;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;

public class ItemRawChickenFricasseeRice extends ItemFood {
	
	public ItemRawChickenFricasseeRice() {
		super(5, 0.4f, false);
		setUnlocalizedName("raw_chicken_fricassee_rice");
		setRegistryName("raw_chicken_fricassee_rice");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "raw_chicken_fricassee_rice");
	}

}