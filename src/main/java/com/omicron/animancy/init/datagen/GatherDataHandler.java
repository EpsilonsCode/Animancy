package com.omicron.animancy.init.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class GatherDataHandler {

    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if(event.includeServer())
        {
            generator.addProvider(new LootModifierProvider(generator));
        }
        if(event.includeClient())
        {
            generator.addProvider(new BlockStateGenerator(generator, fileHelper));
        }
    }
}
