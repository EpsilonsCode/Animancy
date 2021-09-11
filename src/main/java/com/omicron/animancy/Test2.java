package com.omicron.animancy;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.function.Supplier;

public class Test2 {

    public static final DeferredRegister<Test> SPELLS = DeferredRegister.create(Test.class, Animancy.MODID);

    public static final Supplier<IForgeRegistry<Test>> a = SPELLS.makeRegistry("a", () ->  new RegistryBuilder<Test>());

    public static void setup(IEventBus bus) {
        SPELLS.register(bus);
    }

    public static final RegistryObject<Test> B = SPELLS.register("b", Test::new);
}
