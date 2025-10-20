package io.github.techtastic.unclamped.mixin;

import com.simibubi.create.content.kinetics.mechanicalArm.ArmBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ArmBlockEntity.class)
public class MixinArmBlockEntity {
    @Redirect(method = "tickMovementProgress", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F"), remap = false)
    private float unclamped$returnRawSpeed(float a, float b) {
        return b;
    }
}