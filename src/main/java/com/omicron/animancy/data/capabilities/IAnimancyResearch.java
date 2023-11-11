package com.omicron.animancy.data.capabilities;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public interface IAnimancyResearch {
    boolean isResearchDone(ResourceLocation research);

    boolean isStageDone(ResourceLocation research, ResourceLocation stage);




}
