package com.omicron.animancy.init.datagen;

import com.omicron.animancy.Animancy;

import com.omicron.animancy.data.loot_modifiers.BookModifier;
import com.omicron.animancy.init.registries.LootModifierRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifierProvider extends GlobalLootModifierProvider
{

    public LootModifierProvider(DataGenerator gen)
    {
        super(gen, Animancy.MODID);
    }

    @Override
    protected void start() {


        add("book_modifier",
                new BookModifier(new LootItemCondition[]{
                        LootItemRandomChanceCondition.randomChance(0.98F).build()
                }));
    }
}
