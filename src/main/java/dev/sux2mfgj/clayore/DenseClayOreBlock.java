package dev.sux2mfgj.clayore;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.ToolType;

public class DenseClayOreBlock extends Block
{
    public DenseClayOreBlock()
    {
        super(
            Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(1.5f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1)
                    .sound(SoundType.STONE));

        setRegistryName(new ResourceLocation(ClayOre.modid, "dense_clay_ore"));
    }
}
