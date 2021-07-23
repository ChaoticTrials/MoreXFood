package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.block.BaseCrop;
import de.melanx.morexfood.block.OreSalt;
import de.melanx.morexfood.util.ModRegistration;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, MoreXFood.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block> blockRegistry : ModRegistration.BLOCKS.getEntries()) {
            Block block = blockRegistry.get();
            if (!(block instanceof OreSalt))
                this.getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(this.model(block, state)).build());
            else
                this.getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(this.modelDefault(block)).build());
        }
    }

    private ModelFile modelDefault(Block block) {
        //noinspection ConstantConditions
        String name = block.getRegistryName().getPath();
        return this.models().cubeAll(name, this.modLoc("block/" + name));
    }

    private ModelFile model(Block block, BlockState state) {
        //noinspection ConstantConditions
        String name = block.getRegistryName().getPath();
        IntegerProperty properties = ((BaseCrop) state.getBlock()).getAgeProperty();
        name = name + "_" + state.getValue(properties);
        return this.models().crop(name, this.modLoc(String.format("block/%s", name)));
    }
}
