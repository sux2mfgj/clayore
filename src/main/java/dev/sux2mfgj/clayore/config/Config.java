package com.sux2mfgj.clayore.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

import org.apache.commons.lang3.tuple.Pair;
import com.sux2mfgj.clayore.ClayOre;

@EventBusSubscriber(modid = ClayOre.modid, bus = EventBusSubscriber.Bus.MOD)
public class Config {

    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static int nClayBallsFromClayOre;
    public static int clayOreVeinSize;
    public static int nVainsOfClayOre;

    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);

        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == Config.CLIENT_SPEC) {
            bakeConfig();
        }
    }

    public static void bakeConfig() {
        nClayBallsFromClayOre = CLIENT.nClayBallsFromClayOre.get();
        clayOreVeinSize = CLIENT.clayOreVeinSize.get();
    }

    public static class ClientConfig {

        public final IntValue nClayBallsFromClayOre;
        public final IntValue clayOreVeinSize;
        public final IntValue nVainsOfClayOre;

        public ClientConfig(ForgeConfigSpec.Builder builder) {
            nClayBallsFromClayOre = builder
                .comment("How may drop clay balls from `Clay Ore`.")
                .translation(ClayOre.modid + ".config." + "nClayBallsFromClayOre")
                .defineInRange("nClayBallsFromClayOre", 5, 1, 100);

            clayOreVeinSize = builder
                .comment("A vein size of `Clay Ore`.")
                .translation(ClayOre.modid + ".config." + "clayOreVeinSize")
                .defineInRange("clayOreVeinSize", 17, 1, 30);

            nVainsOfClayOre = builder
                .comment("Number of vains of `Clay Ore` in a chank.")
                .translation(ClayOre.modid + ".config." + "nVainsOfClayOre")
                .defineInRange("nVainsOfClayOre", 20, 1, 1000);
        }
    }
}
