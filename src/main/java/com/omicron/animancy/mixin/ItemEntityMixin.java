package com.omicron.animancy.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @Inject(at = @At("HEAD"), method = "hurt", cancellable = true)
    private void attackEntityFrom(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
