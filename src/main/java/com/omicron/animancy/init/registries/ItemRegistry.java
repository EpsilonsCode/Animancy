package com.omicron.animancy.init.registries;

import com.omicron.animancy.Animancy;
import com.omicron.animancy.common.item.BookItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    private static DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Animancy.MODID);

    public static void setup(IEventBus bus) {
        ITEM_REGISTER.register(bus);
    }

    public static DeferredRegister<Item> getInstance()
    {
        return ITEM_REGISTER;
    }

    public static final RegistryObject<BookItem> BOOK_ITEM = ITEM_REGISTER.register("book_item", () -> new BookItem());
}
