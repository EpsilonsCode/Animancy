package com.omicron.animancy.data.research;

import com.omicron.animancy.Animancy;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public class ResearchEntryRequirement implements ResearchRequirement<ResearchEntry>{

    private final ResearchEntry entry;

    public static final ResourceLocation ID = new ResourceLocation(Animancy.MODID, "research_entry");

    public ResearchEntryRequirement(ResearchEntry entry) {
        this.entry = entry;
    }

    @Override
    public ResearchEntry get() {
        return entry;
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ResearchEntryRequirement requirement)
            return requirement.entry.equals(this.entry);
        return false;
    }
}
