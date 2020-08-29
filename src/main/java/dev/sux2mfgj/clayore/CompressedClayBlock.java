package dev.sux2mfgj.clayore;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.storage.loot.LootContext;
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
                    .hardnessAndResistance(0.6f)
                    .harvestTool(ToolType.SHOVEL)
                    .harvestLevel(1)
                    .sound(SoundType.WET_GRASS));

        setRegistryName(new ResourceLocation(ClayOre.modid, "compressed_clay"));
    }

    @Override
    public List<ItemStack> getDrops(BlockState state,
            LootContext.Builder builder)
    {
        ArrayList<ItemStack> drop_list = new ArrayList<ItemStack>();
        drop_list.add(new ItemStack(ClayOre.compressedClayBlockItem, 1));
        return drop_list;
    }
}
