package supers.test.mod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class DynamiteEntity extends ThrownItemEntity{

    public DynamiteEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super((EntityType<? extends ThrownItemEntity>)entityType, world);
	}
 
	public DynamiteEntity(World world, LivingEntity owner) {
		super((EntityType<? extends ThrownItemEntity>)SupersTestMod.DYNAMITE_ENTITY_TYPE, owner, world);
	}
 
	public DynamiteEntity(World world, double x, double y, double z) {
		super((EntityType<? extends ThrownItemEntity>)SupersTestMod.DYNAMITE_ENTITY_TYPE, x, y, z, world);
    }

    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.5f, Explosion.DestructionType.DESTROY);
        this.kill();
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.5f, Explosion.DestructionType.DESTROY);
        this.kill();
    }

    @Override
    protected Item getDefaultItem() {
        return SupersTestMod.DYNAMITE;
    }
    
}
