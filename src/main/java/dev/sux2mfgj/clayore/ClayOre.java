package dev.sux2mfgj.clayore;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import dev.sux2mfgj.clayore.config.Config;

import java.util.stream.Collectors;

@Mod("clayore")
public class ClayOre
{
    public static final String modid = "clayore";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static ClayOreBlock clayOreBlock;
    public static Item clayOreBlockItem;

    public ClayOre()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);

        clayOreBlock = new ClayOreBlock();
        clayOreBlockItem = new BlockItem(clayOreBlock,
                new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
                .setRegistryName(clayOreBlock.getRegistryName());


        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event)
        {
            event.getRegistry().register(clayOreBlock);
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event)
        {
            event.getRegistry().register(clayOreBlockItem);
        }
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        OreGeneration.setupBiomeFeature();
    }
}
