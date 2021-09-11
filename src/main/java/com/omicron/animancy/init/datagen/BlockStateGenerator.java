package com.omicron.animancy.init.datagen;


import com.omicron.animancy.Animancy;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;



public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, Animancy.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {

    }
}
