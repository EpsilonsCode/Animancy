package com.omicron.animancy.init;


import com.omicron.animancy.Test2;
import com.omicron.animancy.common.network.APINetwork;
import com.omicron.animancy.data.reload_listeners.ResearchManager;
import com.omicron.animancy.init.datagen.GatherDataHandler;
import com.omicron.animancy.init.registries.BlockRegistry;
import com.omicron.animancy.init.registries.ItemRegistry;
import com.omicron.animancy.init.registries.LootModifierRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.NewRegistryEvent;

public class CommonInitialization
{

    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        setupRegistries(bus);
        bus.addListener(GatherDataHandler::gatherData);
        bus.addListener(CommonInitialization::commonSetup);
        MinecraftForge.EVENT_BUS.addListener(CommonInitialization::tick);
        MinecraftForge.EVENT_BUS.addListener(CommonInitialization::testAddReload);
    }

    private static void register(NewRegistryEvent event)
    {

    }

    private static void testAddReload(AddReloadListenerEvent event)
    {
        event.addListener(new ResearchManager());
    }

    private static void tick(LivingSpawnEvent event)
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
