package de.melanx.morexfood.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class OreSalt extends Block {

    public OreSalt() {
        super(Properties.of(Material.STONE)
                .strength(1.5F, 10)
                .sound(SoundType.STONE));
    }
}
