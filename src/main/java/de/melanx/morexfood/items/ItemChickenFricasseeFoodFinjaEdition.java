package de.melanx.morexfood.items;


import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemChickenFricasseeFoodFinjaEdition extends ItemFood {
	
	public ItemChickenFricasseeFoodFinjaEdition() {
		super(20, 9.5f, false);
		setUnlocalizedName("chicken_fricassee_special");
		setRegistryName("chicken_fricassee_special");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "chicken_fricassee_special");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("chickenFricasseeSpecial", this);
	}

}