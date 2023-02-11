package com.omicron.animancy.common.network;

import com.google.common.collect.Sets;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.Set;
import java.util.function.Supplier;

public class TestPacket implements IMessage{

    private final int id;

    public TestPacket(int id) {
        this.id = id;
    }

    public TestPacket(FriendlyByteBuf buf)
    {
        id = buf.readInt();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(id);
    }

    @Override
    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
           Entity entity1 = ctx.get().getSender().getCommandSenderWorld().getEntity(id);
            if(entity1 instanceof Mob)
            {
                Mob entity = (Mob) entity1;
                Set<Goal> essa = Sets.newLinkedHashSet();
                for(WrappedGoal goal : entity.goalSelector.availableGoals)
                {
                    essa.add(goal.getGoal());
                }
                for(Goal goal : essa)
                {
                    entity.goalSelector.removeGoal(goal);
                }
                essa = Sets.newLinkedHashSet();
                for(WrappedGoal goal : entity.targetSelector.availableGoals)
                {
                    essa.add(goal.getGoal());
                }
                for(Goal goal : essa)
                {
                    entity.targetSelector.removeGoal(goal);
                }
                entity.goalSelector.addGoal(7, new LookAtPlayerGoal(entity, Player.class, 6.0F));
            }
        });
        return true;
    }
}
