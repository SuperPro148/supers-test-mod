package supers.test.mod.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

@Mixin(LivingEntity.class)
public abstract class ExplodingBunnyMixin extends Entity {
    public ExplodingBunnyMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onDeath", at = @At("TAIL"))
    private void superstestmod$makeBunniesExplode(CallbackInfo ci) {
        if (this.getType() == EntityType.RABBIT) {
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 6.0f, Explosion.DestructionType.DESTROY);
        }
    }
}