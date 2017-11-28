package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemRawChickenFricasseeRice extends ItemFood {
	
	final Potion potion = Potion.getPotionFromResourceLocation("poison");
	
	public ItemRawChickenFricasseeRice() {
		super(5, 0.4f, false);
		setUnlocalizedName("raw_chicken_fricassee_rice");
		setRegistryName("raw_chicken_fricassee_rice");
		setCreativeTab(morexfood.creativeTab);
		setPotionEffect(new PotionEffect(potion, 100, 0), 90);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "raw_chicken_fricassee_rice");
	}

}