package com.omicron.animancy.init.registries;

import com.omicron.animancy.Animancy;
import com.omicron.animancy.data.loot_modifiers.BookModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LootModifierRegistry {

    private static DeferredRegister<GlobalLootModifierSerializer<?>> GLM_REGISTER = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, Animancy.MODID);

    public static void setup(IEventBus bus) {
        GLM_REGISTER.register(bus);
    }

    public static DeferredRegister<GlobalLootModifierSerializer<?>> getInstance()
    {
        return GLM_REGISTER;
    }

    public static final RegistryObject<BookModifier.Serializer> BOOK_MODIFIER = GLM_REGISTER.register("book_modifier", BookModifier.Serializer::new);
}
