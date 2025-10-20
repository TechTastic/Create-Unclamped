package io.github.techtastic.unclamped.mixin;

import com.simibubi.create.content.kinetics.motor.KineticScrollValueBehaviour;
import com.simibubi.create.infrastructure.config.AllConfigs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(KineticScrollValueBehaviour.class)
public class MixinKineticScrollValueBehaviour {
    @ModifyArg(method = "createBoard", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/blockEntity/behaviour/ValueSettingsBoard;<init>(Lnet/minecraft/network/chat/Component;IILjava/util/List;Lcom/simibubi/create/foundation/blockEntity/behaviour/ValueSettingsFormatter;)V"), index = 1)
    private int unclamped$useRawSpeed(int maxValue) {
        return AllConfigs.server().kinetics.maxRotationSpeed.get();
    }
}
