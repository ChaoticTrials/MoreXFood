package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemAsparagusPieces extends ItemFood {
	
	public ItemAsparagusPieces() {
		super(1, 0.4f, false);
		setUnlocalizedName("asparagus_pieces");
		setRegistryName("asparagus_pieces");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "asparagus_pieces");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("piecesAsparagus", this);
	}

}