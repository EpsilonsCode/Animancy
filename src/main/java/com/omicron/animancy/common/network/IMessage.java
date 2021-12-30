package com.omicron.animancy.common.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public interface IMessage {

    void toBytes(PacketBuffer buf);

    boolean handle(Supplier<NetworkEvent.Context> ctx);
}
