package com.omicron.animancy.util;

import com.omicron.animancy.data.research.CriterionTriggerRequirement;
import com.omicron.animancy.data.research.ResearchRequirement;
import com.omicron.animancy.data.research.ResearchRequirementManager;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.function.Predicate;

public class CriterionTriggerUtils {
    public static <T extends AbstractCriterionTriggerInstance> void onCriterionTrigger(ResourceLocation triggerId, ServerPlayer player, Predicate<T> predicate)
    {
        for(ResearchRequirement<?> requirement : ResearchRequirementManager.getAllRequirements())
        {
            if(requirement instanceof CriterionTriggerRequirement criterionTriggerRequirement)
            {
                CriterionTriggerInstance instance = criterionTriggerRequirement.get();
                if(instance.equals(triggerId))
                {
                    if(instance instanceof AbstractCriterionTriggerInstance triggerInstance)
                    {
                        LootContext lootcontext = EntityPredicate.createContext(player, player);
                        if(predicate.test((T) instance) && triggerInstance.player.matches(lootcontext))
                        {
                            //TODO call all listeners
                        }
                    }
                }
            }
        }
    }
}
