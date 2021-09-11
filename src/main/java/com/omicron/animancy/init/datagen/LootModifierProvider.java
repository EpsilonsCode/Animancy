package com.omicron.animancy.init.datagen;

import com.omicron.animancy.Animancy;
import com.omicron.animancy.data.loot_modifiers.BookModifier;
import com.omicron.animancy.init.registries.LootModifierRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.RandomChance;
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
                LootModifierRegistry.BOOK_MODIFIER.get(),
                new BookModifier(new ILootCondition[]{
                        RandomChance.randomChance(0.98F).build()
                }));
    }
}
