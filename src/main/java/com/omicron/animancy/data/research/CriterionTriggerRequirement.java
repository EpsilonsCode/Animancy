package com.omicron.animancy.data.research;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.resources.ResourceLocation;

public class CriterionTriggerRequirement implements ResearchRequirement<CriterionTriggerInstance>{

    private final CriterionTriggerInstance triggerInstance;

    public CriterionTriggerRequirement(CriterionTriggerInstance triggerInstance) {
        this.triggerInstance = triggerInstance;
    }

    @Override
    public CriterionTriggerInstance get() {
        return triggerInstance;
    }

    @Override
    public ResourceLocation getId() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CriterionTriggerRequirement requirement)
            return requirement.triggerInstance.getCriterion().equals(this.triggerInstance.getCriterion());
        return false;
    }
}
