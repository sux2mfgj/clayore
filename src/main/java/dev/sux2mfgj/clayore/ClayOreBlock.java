package dev.sux2mfgj.clayore;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

import dev.sux2mfgj.clayore.config.Config;

public class ClayOreBlock extends Block
{
    public ClayOreBlock()
    {
        super(
                Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(1.5f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1)
                    .sound(SoundType.STONE)
                );

        setRegistryName(new ResourceLocation(ClayOre.modid, "clay_ore"));
    }
}
