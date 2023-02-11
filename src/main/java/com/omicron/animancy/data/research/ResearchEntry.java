package com.omicron.animancy.data.research;

import net.minecraft.resources.ResourceLocation;

public abstract class ResearchEntry {
    private final ResourceLocation id;

    protected ResearchEntry(ResourceLocation id) {
        this.id = id;
    }
}
