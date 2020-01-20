//package de.melanx.morexfood.world.village;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockCrops;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.init.Blocks;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.world.World;
//import net.minecraft.world.gen.structure.StructureBoundingBox;
//import net.minecraft.world.gen.structure.StructureComponent;
//import net.minecraft.world.gen.structure.StructureVillagePieces;
//
//import java.util.List;
//import java.util.Random;
//
//import de.melanx.morexfood.block.ModBlocks;
//
//public class VillageCustomCropField extends StructureVillagePieces.House1 {
//
//    private static final int X_SIZE = 13;
//    private static final int Y_SIZE = 4;
//    private static final int Z_SIZE = 9;
//
//    private int averageGroundLevel = -1;
//
//    public VillageCustomCropField() {
//
//    }
//
//    public VillageCustomCropField(StructureBoundingBox boundingBox, EnumFacing par5) {
//        this.setCoordBaseMode(par5);
//        this.boundingBox = boundingBox;
//    }
//
//    public static VillageCustomCropField buildComponent(List<StructureComponent> pieces, int p1, int p2, int p3, EnumFacing p4) {
//        StructureBoundingBox boundingBox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, X_SIZE, Y_SIZE, Z_SIZE, p4);
//        return canVillageGoDeeper(boundingBox) && StructureComponent.findIntersecting(pieces, boundingBox) == null ? new VillageCustomCropField(boundingBox, p4) : null;
//    }
//
//    @Override
//    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb) {
//        if(this.averageGroundLevel < 0) {
//           this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
//           if(this.averageGroundLevel < 0) {
//                return true;
//            }
//            this.boundingBox.offset(0, this.averageGroundLevel-this.boundingBox.maxY+Y_SIZE-1, 0);
//        }
//
//        this.fillWithBlocks(world, sbb, 0, 0, 0, X_SIZE-1, Y_SIZE-1, Z_SIZE-1, Blocks.AIR);
//        this.spawnActualHouse(world, random, sbb);
//
//        for(int i = 0; i < X_SIZE; i++) {
//            for(int j = 0; j < Z_SIZE; j++) {
//                this.clearCurrentPositionBlocksUpwards(world, i, Y_SIZE, j, sbb);
//                this.replaceAirAndLiquidDownwards(world, Blocks.DIRT.getDefaultState(), i, -1, j, sbb);
//            }
//        }
//
//        return true;
//    }
//
//    public void fillWithBlocks(World world, StructureBoundingBox sbb, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, Block block) {
//    	   this.fillWithBlocks(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, block.getDefaultState(), block.getDefaultState(), false);
//    }
//
//    public void spawnActualHouse(World world, Random random, StructureBoundingBox sbb) {
//        this.fillWithBlocks(world, sbb, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND);
//        this.fillWithBlocks(world, sbb, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND);
//        this.fillWithBlocks(world, sbb, 7, 0, 1, 8, 0, 7, Blocks.FARMLAND);
//        this.fillWithBlocks(world, sbb, 10, 0, 1, 11, 0, 7, Blocks.FARMLAND);
//        this.fillWithBlocks(world, sbb, 0, 0, 0, 0, 0, 8, Blocks.LOG);
//        this.fillWithBlocks(world, sbb, 6, 0, 0, 6, 0, 8, Blocks.LOG);
//        this.fillWithBlocks(world, sbb, 12, 0, 0, 12, 0, 8, Blocks.LOG);
//        this.fillWithBlocks(world, sbb, 1, 0, 0, 11, 0, 0, Blocks.LOG);
//        this.fillWithBlocks(world, sbb, 1, 0, 8, 11, 0, 8, Blocks.LOG);
//        this.fillWithBlocks(world, sbb, 3, 0, 1, 3, 0, 7, Blocks.WATER);
//        this.fillWithBlocks(world, sbb, 9, 0, 1, 9, 0, 7, Blocks.WATER);
//
//        for(int i = 1; i <= 7; ++i) {
//            this.setBlockState(world, this.getRandomCropType(random), 1, 1, i, sbb);
//            this.setBlockState(world, this.getRandomCropType(random), 2, 1, i, sbb);
//            this.setBlockState(world, this.getRandomCropType(random), 4, 1, i, sbb);
//            this.setBlockState(world, this.getRandomCropType(random), 5, 1, i, sbb);
//            this.setBlockState(world, this.getRandomCropType(random), 7, 1, i, sbb);
//            this.setBlockState(world, this.getRandomCropType(random), 8, 1, i, sbb);
//            this.setBlockState(world, this.getRandomCropType(random), 10, 1, i, sbb);
//            this.setBlockState(world, this.getRandomCropType(random), 11, 1, i, sbb);
//        }
//    }
//
//    private IBlockState getRandomCropType(Random random) {
//        int randomMeta = MathHelper.getInt(random, 1, 7);
//        switch(random.nextInt(4)) {
//            case 0:
//                return ModBlocks.cropAgaricus.getDefaultState().withProperty(BlockCrops.AGE, randomMeta);
//            case 1:
//                return ModBlocks.cropAsparagus.getDefaultState().withProperty(BlockCrops.AGE, randomMeta);
//            case 2:
//                return ModBlocks.cropPea.getDefaultState().withProperty(BlockCrops.AGE, randomMeta);
//            default:
//                return ModBlocks.cropRice.getDefaultState().withProperty(BlockCrops.AGE, randomMeta);
//        }
//    }
//}