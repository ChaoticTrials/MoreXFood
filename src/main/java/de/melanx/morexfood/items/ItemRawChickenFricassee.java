package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRawChickenFricassee extends ItemFood {
	
	final Potion potion = Potion.getPotionFromResourceLocation("poison");
	
	public ItemRawChickenFricassee() {
		super(4, 0.05f, false);
		setUnlocalizedName("raw_chicken_fricassee");
		setRegistryName("raw_chicken_fricassee");
		setCreativeTab(morexfood.creativeTab);
		setPotionEffect(new PotionEffect(potion, 150, 0), 95);
	}
		
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "raw_chicken_fricassee");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("rawChickenFricassee", this);
	}

}