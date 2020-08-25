package dev.sux2mfgj.clayore;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.storage.loot.LootContext;

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

    @Override
    public List<ItemStack> getDrops(BlockState state,
            LootContext.Builder builder)
    {
        ArrayList<ItemStack> drop_list = new ArrayList<ItemStack>();
        drop_list.add(new ItemStack(Items.CLAY_BALL, Config.nClayBallsFromClayOre));
        return drop_list;
    }
}
