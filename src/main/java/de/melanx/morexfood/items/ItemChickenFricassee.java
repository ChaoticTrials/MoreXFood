package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemChickenFricassee extends ItemFood {
	
	public ItemChickenFricassee() {
		super(11, 0.55f, false);
		setUnlocalizedName("chicken_fricassee");
		setRegistryName("chicken_fricassee");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "chicken_fricassee");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("chickenFricassee", this);
	}

}