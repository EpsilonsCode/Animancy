package com.omicron.animancy.data.research;

import com.omicron.animancy.data.reload_listeners.ResearchManager;
import com.omicron.animancy.init.CommonInitialization;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.*;

public class ResearchRequirementManager {
    HashMap<UUID, List<ResearchRequirement<?>>> fulfilledRequirements;

    private static final Map<UUID, Map<ResourceLocation, List<ResearchRequirement<?>>>> map = new HashMap<>();

    private static final List<ResearchRequirement<?>> allRequirements = new ArrayList<>();

    public static void addRequirementIfNotPresent(final ResearchRequirement<?> requirement)
    {
        if(!allRequirements.contains(requirement))
            allRequirements.add(requirement);
    }

    public static List<ResearchRequirement<?>> getResearchEntryRequirementByPlayer(Player player)
    {
        return map.get(player.getUUID()).get(ResearchEntryRequirement.ID);
    }

    public static List<ResearchRequirement<?>> getCriterionTriggerRequirementByPlayer(Player player)
    {
        return map.get(player.getUUID()).get(ResearchEntryRequirement.ID);
    }

    public static List<ResearchRequirement<?>> getAllRequirements()
    {
        return allRequirements;
    }

    public static void resolve(ResearchRequirement<?> requirement)
    {
        for(Map.Entry<ResourceLocation, ResearchEntry> entry : CommonInitialization.researchManager.researchEntries.entrySet())
        {
//            entry.getValue().
        }


    }


}
