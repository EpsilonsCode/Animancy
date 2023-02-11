package com.omicron.animancy.init.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

public class GatherDataHandler {

    public static void gatherData(GatherDataEvent event)
    {
        System.out.println("ez");
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if(event.includeServer())
        {
            generator.addProvider(true, new LootModifierProvider(generator));
        }
        if(event.includeClient())
        {
            generator.addProvider(true, new BlockStateGenerator(generator, fileHelper));
        }
    }
}
