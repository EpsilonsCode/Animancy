package com.omicron.animancy.common.network;

import com.omicron.animancy.Animancy;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class APINetwork {

    private static SimpleChannel INSTANCE;

    private static int ID = 0;

    private static int nextID()
    {
        return ID++;
    }

    public static void registerMessages()
    {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Animancy.MODID, "api_network"),
                () -> "1.0",
                s -> true,
                s -> true);
        addMessage(TestPacket.class)
                .encoder(TestPacket::toBytes)
                .decoder(TestPacket::new)
                .consumerNetworkThread(TestPacket::handle)
                .add();

    }

    public static SimpleChannel getInstance()
    {
        return INSTANCE;
    }

    public static <T> SimpleChannel.MessageBuilder<T> addMessage(final Class<T> type)
    {
        return INSTANCE.messageBuilder(type, nextID());
    }

    public static void sendToClient(Object packet, ServerPlayer player)
    {
        INSTANCE.sendTo(packet, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToServer(Object packet)
    {
        INSTANCE.sendTo(packet, Minecraft.getInstance().player.connection.getConnection(), NetworkDirection.PLAY_TO_SERVER);
    }
}
