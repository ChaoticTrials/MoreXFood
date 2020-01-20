package de.melanx.morexfood.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OreSalt extends Block {

    public OreSalt() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5F, 10)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE));
    }
}