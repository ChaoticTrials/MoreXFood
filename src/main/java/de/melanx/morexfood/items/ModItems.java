package de.melanx.morexfood.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

   // public static ItemBase name = new ItemBase("name");
   public static ItemBase itemKnife = new ItemBase("knife");
   static {
	   itemKnife.setContainerItem(itemKnife);
	   itemKnife.setMaxStackSize(1);
   }
   public static ItemOre dustSalt = new ItemOre("salt", "dustSalt");
   public static ItemPeasSeed peasSeed = new ItemPeasSeed();
   public static ItemPeas peas = new ItemPeas();
   public static ItemCarrotPieces carrotPieces = new ItemCarrotPieces();
   public static ItemAsparagus asparagus = new ItemAsparagus();
   public static ItemAsparagusSeed asparagusSeed = new ItemAsparagusSeed();
   public static ItemAgaricus agaricus = new ItemAgaricus();
   public static ItemAgaricusSeed agaricusSeed = new ItemAgaricusSeed();
   public static ItemRice rice = new ItemRice();
   public static ItemRiceSeed riceSeed = new ItemRiceSeed();
   public static ItemMixedVegetables mixedVegetables = new ItemMixedVegetables();
   public static ItemAsparagusPieces asparagusPieces = new ItemAsparagusPieces();
   public static ItemChickenPieces chickenPieces = new ItemChickenPieces();
   public static ItemRawChickenFricassee rawChickenFricassee = new ItemRawChickenFricassee();
   public static ItemChickenFricassee chickenFricassee = new ItemChickenFricassee();
   public static ItemRawChickenFricasseeRice rawChickenFricasseeRice = new ItemRawChickenFricasseeRice();
   public static ItemChickenFricasseeRice chickenFricasseeRice = new ItemChickenFricasseeRice();
   public static ItemChickenFricasseeFoodFinjaEdition specialChickenFricassee = new ItemChickenFricasseeFoodFinjaEdition();
   public static ItemRawChickenFricasseeFoodFinjaEdition specialRawChickenFricassee = new ItemRawChickenFricasseeFoodFinjaEdition();

   public static void register(IForgeRegistry<Item> registry) {
       registry.registerAll(
               itemKnife,
               dustSalt,
               peas,
               peasSeed,
               asparagus,
               asparagusSeed,
               agaricus,
               agaricusSeed,
               rice,
               riceSeed,
               mixedVegetables,
               asparagusPieces,
               carrotPieces,
               chickenPieces,
               rawChickenFricassee,
               rawChickenFricasseeRice,
               specialRawChickenFricassee,
               chickenFricassee,
               chickenFricasseeRice,
               specialChickenFricassee
       );
   }
  
   public static void registerModels() {
       itemKnife.registerItemModel();
       dustSalt.registerItemModel();
       peasSeed.registerItemModel();
       peas.registerItemModel();
       carrotPieces.registerItemModel();
       asparagus.registerItemModel();
       asparagusSeed.registerItemModel();
       agaricus.registerItemModel();
       agaricusSeed.registerItemModel();
       rice.registerItemModel();
       riceSeed.registerItemModel();
       mixedVegetables.registerItemModel();
       asparagusPieces.registerItemModel();
       chickenPieces.registerItemModel();
       rawChickenFricassee.registerItemModel();
       chickenFricassee.registerItemModel();
       rawChickenFricasseeRice.registerItemModel();
       chickenFricasseeRice.registerItemModel();
       specialChickenFricassee.registerItemModel();
       specialRawChickenFricassee.registerItemModel();
   }
}