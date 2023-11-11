package com.omicron.animancy.data.loot_modifiers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.omicron.animancy.init.registries.ItemRegistry;
import com.omicron.animancy.init.registries.LootModifierRegistry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

public class BookModifier extends LootModifier {
    public static final RegistryObject<Codec<BookModifier>> CODEC = LootModifierRegistry.GLM_REGISTER.register("book_modifier", () ->
            RecordCodecBuilder.create(inst -> {

                        return codecStart(inst).apply(inst, BookModifier::new);
                    }
            ));

    public static void dummy() {
        CODEC.getId();
    }

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public BookModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        //System.out.println("ez");
        //System.out.println(LootContextParamSets.getKey(context.getLootTable(context.getQueriedLootTableId()).getParamSet()));
        LootTable table = context.getLootTable(context.getQueriedLootTableId());
        String string = LootContextParamSets.getKey(table.getParamSet()).getPath();
        if (string.equals("chest")) {
            System.out.println(string);
            //System.out.println(string.equals("chest123"));
            generatedLoot.add(new ItemStack(ItemRegistry.BOOK_ITEM.get()));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
