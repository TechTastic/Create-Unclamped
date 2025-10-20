package io.github.techtastic.unclamped.mixin;

import com.simibubi.create.content.kinetics.motor.CreativeMotorBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueBehaviour;
import com.simibubi.create.infrastructure.config.AllConfigs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreativeMotorBlockEntity.class)
public class MixinCreativeMotorBlockEntity {
    @Redirect(method = "addBehaviours", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/blockEntity/behaviour/scrollValue/ScrollValueBehaviour;between(II)Lcom/simibubi/create/foundation/blockEntity/behaviour/scrollValue/ScrollValueBehaviour;"), remap = false)
    private ScrollValueBehaviour unclamped$fixMaxRPM(ScrollValueBehaviour instance, int min, int max) {
        int newMax = AllConfigs.server().kinetics.maxRotationSpeed.get();
        int newMin = -newMax;
        return instance.between(newMin, newMax);
    }
}