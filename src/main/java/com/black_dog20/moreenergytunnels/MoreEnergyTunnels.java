package com.black_dog20.moreenergytunnels;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoreEnergyTunnels.MOD_ID)
public class MoreEnergyTunnels {

    public static final String MOD_ID = "moreenergytunnels";
    private static final Logger LOGGER = LogManager.getLogger();

    public MoreEnergyTunnels() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();

        if (ModList.get().isLoaded("compactmachines")) {
            MinecraftForge.EVENT_BUS.register(new ModCompat());
        }

        MinecraftForge.EVENT_BUS.register(this);
    }


    private static final String PROTOCOL_VERSION = Integer.toString(1);

    public static final SimpleChannel NETWORK = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(MOD_ID, "network"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    public static Logger getLogger() {
        return LOGGER;
    }
}
