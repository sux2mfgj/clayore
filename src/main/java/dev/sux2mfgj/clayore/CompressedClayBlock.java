package dev.sux2mfgj.clayore;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.item.Items;
import net.minecraftforge.common.ToolType;

import dev.sux2mfgj.clayore.ClayOre;

public class CompressedClayBlock extends Block
{
    public CompressedClayBlock()
    {
        super(
            Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(0.8f)
                    .harvestTool(ToolType.SHOVEL)
                    .harvestLevel(1)
                    .sound(SoundType.WET_GRASS));

        setRegistryName(new ResourceLocation(ClayOre.modid, "compressed_clay"));
    }
}
