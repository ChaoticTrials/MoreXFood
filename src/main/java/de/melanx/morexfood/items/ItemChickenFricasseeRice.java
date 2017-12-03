package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemChickenFricasseeRice extends ItemFood {
	
	public ItemChickenFricasseeRice() {
		super(19, 8.5f, false);
		setUnlocalizedName("chicken_fricassee_rice");
		setRegistryName("chicken_fricassee_rice");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "chicken_fricassee_rice");
	}

	public void initOreDict() {
		OreDictionary.registerOre("chickenFricasseeRice", this);
	}
	
}