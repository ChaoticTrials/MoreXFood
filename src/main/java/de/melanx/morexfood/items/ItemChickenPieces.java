package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemChickenPieces extends ItemFood {
	
	public ItemChickenPieces() {
		super(1, 0.4f, false);
		setUnlocalizedName("chicken_pieces");
		setRegistryName("chicken_pieces");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "chicken_pieces");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("piecesChicken", this);
	}

}