package com.omicron.animancy.common.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public interface IMessage {

    void toBytes(FriendlyByteBuf buf);

    boolean handle(Supplier<NetworkEvent.Context> ctx);
}
