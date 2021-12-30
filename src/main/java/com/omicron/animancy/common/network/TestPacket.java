package com.omicron.animancy.common.network;

import com.google.common.collect.Sets;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Set;
import java.util.function.Supplier;

public class TestPacket implements IMessage{

    private final int id;

    public TestPacket(int id) {
        this.id = id;
    }

    public TestPacket(PacketBuffer buf)
    {
        id = buf.readInt();
    }

    @Override
    public void toBytes(PacketBuffer buf) {
        buf.writeInt(id);
    }

    @Override
    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
           Entity entity1 = ctx.get().getSender().getCommandSenderWorld().getEntity(id);
            if(entity1 instanceof MobEntity)
            {
                MobEntity entity = (MobEntity) entity1;
                Set<Goal> essa = Sets.newLinkedHashSet();
                for(PrioritizedGoal goal : entity.goalSelector.availableGoals)
                {
                    essa.add(goal.getGoal());
                }
                for(Goal goal : essa)
                {
                    entity.goalSelector.removeGoal(goal);
                }
                essa = Sets.newLinkedHashSet();
                for(PrioritizedGoal goal : entity.targetSelector.availableGoals)
                {
                    essa.add(goal.getGoal());
                }
                for(Goal goal : essa)
                {
                    entity.targetSelector.removeGoal(goal);
                }
                entity.goalSelector.addGoal(7, new LookAtGoal(entity, PlayerEntity.class, 6.0F));
            }
        });
        return true;
    }
}
