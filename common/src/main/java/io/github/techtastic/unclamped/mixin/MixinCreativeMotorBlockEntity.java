package io.github.techtastic.unclamped.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.motor.CreativeMotorBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueBehaviour;
import io.github.techtastic.unclamped.util.ConfigHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CreativeMotorBlockEntity.class)
public class MixinCreativeMotorBlockEntity {
    @WrapOperation(method = "addBehaviours", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/blockEntity/behaviour/scrollValue/ScrollValueBehaviour;between(II)Lcom/simibubi/create/foundation/blockEntity/behaviour/scrollValue/ScrollValueBehaviour;"), remap = false)
    private ScrollValueBehaviour unclamped$fixMaxRPM(ScrollValueBehaviour instance, int min, int max, Operation<ScrollValueBehaviour> original) {
        int newMax = ConfigHelper.getMaxRotationSpeed();
        int newMin = -newMax;
        return original.call(instance, newMin, newMax);
    }
}