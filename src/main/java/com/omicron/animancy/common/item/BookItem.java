package com.omicron.animancy.common.item;

import com.omicron.animancy.Test;
import com.omicron.animancy.Test2;
import com.omicron.animancy.client.BookScreen;
import com.omicron.animancy.common.network.APINetwork;
import com.omicron.animancy.common.network.TestPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

public class BookItem extends Item {
    public BookItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player playerEntity, InteractionHand hand)
    {
        for(RegistryObject<Test> a : Test2.SPELLS.getEntries())
        {
            System.out.println(a.getId());
        }
        if(world.isClientSide())
        {
            Minecraft.getInstance().setScreen(new BookScreen());
        }
        System.out.println("test");
        ItemStack itemStack = playerEntity.getItemInHand(hand);
        Entity entity = Minecraft.getInstance().crosshairPickEntity;
        if(entity != null)
        {
            APINetwork.sendToServer(new TestPacket(entity.getId()));
            System.out.println(entity);
        }
        return InteractionResultHolder.success(itemStack);
    }
}
