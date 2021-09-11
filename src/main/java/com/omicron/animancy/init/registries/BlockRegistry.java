package com.omicron.animancy.init.registries;

import com.omicron.animancy.Animancy;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {

    private static DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Animancy.MODID);

    public static void setup(IEventBus bus) {
        BLOCK_REGISTER.register(bus);
    }

    public static DeferredRegister<Block> getInstance()
    {
        return BLOCK_REGISTER;
    }

}
