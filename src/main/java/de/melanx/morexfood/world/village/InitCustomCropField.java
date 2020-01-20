//package de.melanx.morexfood.world.village;
//
//import de.melanx.morexfood.MoreXFood;
//import de.melanx.morexfood.world.village.handler.VillageCustomCropFieldHandler;
//import net.minecraft.world.gen.structure.MapGenStructureIO;
//import net.minecraftforge.fml.common.registry.VillagerRegistry;
//
//public class InitCustomCropField {
//
//	public static void init() {
//		initCustomCropFieldPart();
//	}
//
//	private static void initCustomCropFieldPart(){
//        VillagerRegistry.instance().registerVillageCreationHandler(new VillageCustomCropFieldHandler());
//        MapGenStructureIO.registerStructureComponent(VillageCustomCropField.class, MoreXFood.MODID+":customCropFieldStructure");
//    }
//
//}