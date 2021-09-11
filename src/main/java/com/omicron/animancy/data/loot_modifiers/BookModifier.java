package com.omicron.animancy.data.loot_modifiers;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class BookModifier extends LootModifier
{

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public BookModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {

        LootTable table = context.getLootTable(context.getQueriedLootTableId());
        if(LootParameterSets.getKey(table.getParamSet()).getPath().equals("chest"));
        {
            //generatedLoot.add(new ItemStack(ItemRegistry.BOOK_ITEM.get()));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<BookModifier>
    {

        @Override
        public BookModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
            return new BookModifier(ailootcondition);
        }

        @Override
        public JsonObject write(BookModifier instance) {
            return makeConditions(instance.conditions);
        }
    }
}
