package io.github.techtastic.unclamped.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ArmBlockEntity.class)
public class MixinArmBlockEntity {
    @WrapOperation(method = "tickMovementProgress", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F"), remap = false)
    private float unclamped$returnRawSpeed(float a, float b, Operation<Float> original) {
        return b;
    }
}