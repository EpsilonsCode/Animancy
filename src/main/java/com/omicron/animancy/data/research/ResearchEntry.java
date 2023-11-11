package com.omicron.animancy.data.research;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.resources.ResourceLocation;

public abstract class ResearchEntry {
    private final ResourceLocation id;
    private final ImmutableMap<Integer, ImmutableList<ResearchRequirement<?>>> researchRequirements;

    private final ImmutableList<ResearchRequirement<?>> visibleRequirements;

    private final ResourceLocation parentId;

    protected ResearchEntry(ResourceLocation id, ImmutableMap<Integer, ImmutableList<ResearchRequirement<?>>> researchRequirements, ImmutableList<ResearchRequirement<?>> visibleRequirements, ResourceLocation parentId) {
        this.id = id;
        this.researchRequirements = researchRequirements;
        this.visibleRequirements = visibleRequirements;
        this.parentId = parentId;
    }

    public ResourceLocation getId() {
        return id;
    }

    public ImmutableMap<Integer, ImmutableList<ResearchRequirement<?>>> getResearchRequirements() {
        return researchRequirements;
    }

    public ImmutableList<ResearchRequirement<?>> getVisibleRequirements() {
        return visibleRequirements;
    }

    public ResourceLocation getParentId() {
        return parentId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ResearchEntry entry)
            return entry.id.equals(this.id);
        return false;
    }
}
