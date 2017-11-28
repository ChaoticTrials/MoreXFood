package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemRawChickenFricasseeFoodFinjaEdition extends ItemFood {
	
	final Potion potion = Potion.getPotionFromResourceLocation("poison");
	
	public ItemRawChickenFricasseeFoodFinjaEdition() {
		super(8, 0.6f, false);
		setUnlocalizedName("raw_chicken_fricassee_special");
		setRegistryName("raw_chicken_fricassee_special");
		setCreativeTab(morexfood.creativeTab);
		setPotionEffect(new PotionEffect(potion, 120, 0), 95);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "raw_chicken_fricassee_special");
	}

}