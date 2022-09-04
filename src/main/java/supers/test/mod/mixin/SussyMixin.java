//WARNING: THIS IS NOT REGISTERED IN THE MIXINS JSON FOR GOOD REASON. IT FREEZES YOUR GAME

package supers.test.mod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntity.class)
public class SussyMixin {
    @Inject(method = "jump", at = @At("TAIL"))
    private void superstestmod$f_ckYou(CallbackInfo ci) throws InterruptedException {
        Thread.sleep(1000);
    }
}