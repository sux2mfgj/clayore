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

    @Override
    public List<ItemStack> getDrops(BlockState state,
            LootContext.Builder builder)
    {
        ArrayList<ItemStack> drop_list = new ArrayList<ItemStack>();
        drop_list.add(new ItemStack(Items.CLAY_BALL, 10));
        return drop_list;
    }
}
