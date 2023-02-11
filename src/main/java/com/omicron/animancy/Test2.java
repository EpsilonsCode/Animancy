package com.omicron.animancy;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Test2 {

    public static final ResourceKey<Registry<Test>> SPELL_KEY = ResourceKey.createRegistryKey(new ResourceLocation(Animancy.MODID, "spells"));

    public static final DeferredRegister<Test> SPELLS = DeferredRegister.create(SPELL_KEY , Animancy.MODID);

    public static final Supplier<IForgeRegistry<Test>> a = SPELLS.makeRegistry(() -> new RegistryBuilder<>());

    public static void setup(IEventBus bus) {
        SPELLS.register(bus);
    }

    public static final RegistryObject<Test> B = SPELLS.register("b", Test::new);

    public static final RegistryObject<Test> C = SPELLS.register("c", Test::new);

}
