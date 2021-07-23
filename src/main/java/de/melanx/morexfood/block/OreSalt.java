package de.melanx.morexfood.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;

public class OreSalt extends Block {

    public OreSalt() {
        super(Properties.of(Material.STONE)
                .strength(1.5F, 10)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE));
    }
}
