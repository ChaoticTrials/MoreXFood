package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.OreDictionary;

public class ItemChickenPieces extends ItemFood {
	
	final Potion potion = Potion.getPotionFromResourceLocation("poison");
	
	public ItemChickenPieces() {
		super(1, 0.2f, false);
		setUnlocalizedName("chicken_pieces");
		setRegistryName("chicken_pieces");
		setCreativeTab(morexfood.creativeTab);
		setPotionEffect(new PotionEffect(potion, 150, 0), 30);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "chicken_pieces");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("piecesChicken", this);
	}

}