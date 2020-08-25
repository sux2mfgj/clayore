package dev.sux2mfgj.clayore;

import net.minecraft.world.biome.Biome;
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
            biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(
                    new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                        ClayOre.clayOreBlock.getDefaultState(),
                        Config.clayOreVeinSize))
                .withPlacement(
                    Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(
                            Config.nVainsOfClayOre, 20, 20, 256))));
        }
    }
}
