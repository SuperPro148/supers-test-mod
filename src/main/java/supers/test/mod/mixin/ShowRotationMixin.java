package supers.test.mod.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class ShowRotationMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderStatusEffectOverlay(Lnet/minecraft/client/util/math/MatrixStack;)V", shift = At.Shift.BEFORE))
    private void superstestmod$renderRotation(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        if (!this.client.options.debugEnabled) {
            float pitch = this.client.player.getPitch();
            float yaw = this.client.player.getHeadYaw();
            Text text = Text.translatable(String.format("%.1f %.1f", MathHelper.wrapDegrees(yaw), pitch));
            this.client.textRenderer.draw(matrices, text, 2, 22, 0xffffffff);
        }
    }
}