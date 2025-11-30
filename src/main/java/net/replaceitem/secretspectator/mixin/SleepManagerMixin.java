package net.replaceitem.secretspectator.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.server.world.SleepManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SleepManager.class)
public class SleepManagerMixin {
    @ModifyExpressionValue(
            method = "update",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/network/ServerPlayerEntity;isSpectator()Z"
            )
    )
    private boolean ignoreSpectatorCheck(boolean original) {
        // Always treat players as non-spectators
        return false;
    }
}
