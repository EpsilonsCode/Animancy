package com.omicron.animancy.init.registries;

import com.mojang.serialization.Codec;
import com.omicron.animancy.Animancy;
import com.omicron.animancy.data.loot_modifiers.BookModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LootModifierRegistry {

    public static DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM_REGISTER = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Animancy.MODID);

    public static void setup(IEventBus bus) {
        GLM_REGISTER.register(bus);
        BookModifier.dummy();
    }

    public static DeferredRegister<Codec<? extends IGlobalLootModifier>> getInstance()
    {
        return GLM_REGISTER;
    }

    //public static final RegistryObject<BookModifier.Serializer> BOOK_MODIFIER = GLM_REGISTER.register("book_modifier", BookModifier.Serializer::new);


}
