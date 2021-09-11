package com.omicron.animancy.common.item;

import com.omicron.animancy.Test2;
import com.omicron.animancy.client.BookScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

public class BookItem extends Item {
    public BookItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
    {
        for(RegistryObject a : Test2.SPELLS.getEntries())
        {
            System.out.println(a.get().getRegistryName());
        }
        if(world.isClientSide())
            Minecraft.getInstance().setScreen(new BookScreen());
        System.out.println("test");
        ItemStack itemStack = playerEntity.getItemInHand(hand);
        return ActionResult.success(itemStack);
    }
}
