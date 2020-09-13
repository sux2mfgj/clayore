package dev.sux2mfgj.clayore;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

import dev.sux2mfgj.clayore.config.Config;

public class OreGeneration
{
    public static void setupBiomeFeature() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            addOreGeneration(biome, ClayOre.clayOreBlock.getDefaultState(), 10, 60,
                    20, 0, 256);
            addOreGeneration(biome, ClayOre.denseClayOreBlock.getDefaultState(), 10, 20,
                    10, 0, 20);
        }
    }
    
    private static void addOreGeneration(Biome biome, BlockState defaultState, int vainSize, int vainNum,
                                         int bottom, int top, int max)
    {
        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                defaultState, vainSize);
        CountRangeConfig rangeConfig = new CountRangeConfig(
                vainNum, bottom, top, max
        );
        biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(oreFeatureConfig).withPlacement(
                        Placement.COUNT_RANGE.configure(
                                rangeConfig
                        )
                )
        );
    }
}
