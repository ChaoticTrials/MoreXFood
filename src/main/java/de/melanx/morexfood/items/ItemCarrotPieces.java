package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemCarrotPieces extends ItemFood {
	
	public ItemCarrotPieces() {
		super(1, 0.6f, false);
		setUnlocalizedName("carrot_pieces");
		setRegistryName("carrot_pieces");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "carrot_pieces");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("piecesCarrot", this);
	}

}