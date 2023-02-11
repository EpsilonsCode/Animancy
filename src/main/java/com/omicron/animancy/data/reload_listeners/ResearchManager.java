package com.omicron.animancy.data.reload_listeners;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.world.level.storage.loot.Deserializers;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ResearchManager extends SimpleJsonResourceReloadListener {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = Deserializers.createLootTableSerializer().create();
    private Map<ResourceLocation, LootTable> tables = ImmutableMap.of();

    public ResearchManager() {
        super(GSON, "research");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> pObject, ResourceManager pResourceManager, ProfilerFiller pProfiler) {
        System.out.println("testing");
        for(Map.Entry<ResourceLocation, JsonElement> entry : pObject.entrySet())
        {
            System.out.println("test123");
        }
    }
}
