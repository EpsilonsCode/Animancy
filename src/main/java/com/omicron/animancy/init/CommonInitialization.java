package com.omicron.animancy.init;

import com.omicron.animancy.Test2;
import com.omicron.animancy.common.network.APINetwork;
import com.omicron.animancy.init.datagen.GatherDataHandler;
import com.omicron.animancy.init.registries.BlockRegistry;
import com.omicron.animancy.init.registries.LootModifierRegistry;
import com.omicron.animancy.init.registries.ItemRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import org.apache.http.config.RegistryBuilder;

public class CommonInitialization
{

    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        setupRegistries(bus);
        bus.addListener(GatherDataHandler::gatherData);
        bus.addListener(CommonInitialization::commonSetup);
        MinecraftForge.EVENT_BUS.addListener(CommonInitialization::tick);
    }

    private static void register(RegistryEvent.NewRegistry event)
    {

    }

    private static void tick(AddReloadListenerEvent event)
    {

    }

    private static void commonSetup(final FMLCommonSetupEvent event)
    {
        APINetwork.registerMessages();
    }

    private static void setupRegistries(IEventBus bus)
    {
        BlockRegistry.setup(bus);
        ItemRegistry.setup(bus);
        LootModifierRegistry.setup(bus);
        Test2.setup(bus);
    }
}
