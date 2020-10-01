package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.block.BaseCrop;
import de.melanx.morexfood.block.OreSalt;
import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.IntegerProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, MoreXFood.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block> blockRegistry : Registry.BLOCKS.getEntries()) {
            Block block = blockRegistry.get();
            if (!(block instanceof OreSalt))
                getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(model(block, state)).build());
            else
                getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(modelDefault(block)).build());
        }
    }

    private ModelFile modelDefault(Block block) {
        String name = block.getRegistryName().getPath();
        return models().cubeAll(name, modLoc("block/" + name));
    }

    private ModelFile model(Block block, BlockState state) {
        String name = block.getRegistryName().getPath();
        IntegerProperty properties = ((BaseCrop) state.getBlock()).getAgeProperty();
        name = name + "_" + state.get(properties);
        return models().crop(name, modLoc(String.format("block/%s", name, state.get(properties))));
    }
}
