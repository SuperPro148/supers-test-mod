package supers.test.mod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.inventory.Inventory;

@Mixin(Inventory.class)
public interface StackMaxCountMixin {
    @Overwrite
    default public int getMaxCountPerStack() {
        return 256;
    }
}