package dev.sux2mfgj.clayore;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import dev.sux2mfgj.clayore.config.Config;

@Mod.EventBusSubscriber(modid = ClayOre.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGeneration
{
    @SubscribeEvent
    public static void setupBiomeFeature(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {

            switch(biome.getCtegory())
            {
                case Biome.Category.NETHER:
                case Biome.Category.THEEND:
                    break;
                default:
                    setupGeneration(biome);
                    break;
            }
        }
    }

    private static void setupGeneration(Biome biome)
    {
        CountRangeConfig range = new CountRangeConfig(
                Config.nVainsOfClayOre, 20, 20, 256);

        /*
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
        */
    }
}
