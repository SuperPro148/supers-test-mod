package supers.test.mod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;

import net.minecraft.item.Items;

@Mixin(Items.class)
public class ThrowableStacksMixin {
    @ModifyConstant(
        method = "<clinit>",
        slice = @Slice(
            from = @At(value = "CONSTANT", args = "stringValue=egg")
        ),
        constant = @Constant(ordinal = 0, intValue = 16))
        private static int superstestmod$increaseEggStackSize(int value) {
            return 64;
        }
    @ModifyConstant(
        method = "<clinit>",
        slice = @Slice(
            from = @At(value = "CONSTANT", args = "stringValue=snowball")
        ),
        constant = @Constant(ordinal = 0, intValue = 16))
        private static int superstestmod$increaseSnowBallStackSize(int value) {
            return 64;
        }
}