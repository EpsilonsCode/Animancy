package com.omicron.animancy.mixin;

import com.omicron.animancy.util.CriterionTriggerUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.loot.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Predicate;

@Mixin(SimpleCriterionTrigger.class)
public abstract class SimpleCriterionTriggerMixin<T extends AbstractCriterionTriggerInstance> implements CriterionTrigger<T> {

    @Inject(method = "trigger", at = @At("HEAD"))
    private void trigger(ServerPlayer pPlayer, Predicate<T> pTestTrigger, CallbackInfo ci)
    {
        CriterionTriggerUtils.onCriterionTrigger(this.getId(), pPlayer, pTestTrigger);
        /*LootContext lootcontext = EntityPredicate.createContext(pPlayer, pPlayer);
        Type superClass = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        //ParameterizedType paramType = (ParameterizedType) type;
        PlayerTrigger.TriggerInstance instance = new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(), EntityPredicate.Composite.ANY);
        if(this.getId().equals(instance.getCriterion()))
        {
            if(pTestTrigger.test((T) instance) && instance.player.matches(lootcontext))
            {
                System.out.println("tescior");
            }
            System.out.println("ticzek: ezi");
        }
        if(type.equals(PlayerTrigger.TriggerInstance.class))
        {

            PlayerTrigger playerTrigger = (PlayerTrigger) (Object)this;
            System.out.println(playerTrigger.getId());
        }

        //System.out.println(paramType.getTypeName());*/
    }
}
