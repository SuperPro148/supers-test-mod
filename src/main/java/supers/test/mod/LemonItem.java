package supers.test.mod;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class LemonItem extends Item {

    public LemonItem(Settings settings) {
        super(settings);
    }
    
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 5));
        ItemEntity explodingEntity = new ItemEntity(world, player.getX(), player.getY() - 1, player.getZ(), new ItemStack(SupersTestMod.LEMON));
        world.spawnEntity(explodingEntity);
        world.createExplosion(explodingEntity, explodingEntity.getX(), explodingEntity.getY(), explodingEntity.getZ(), 6.0f, Explosion.DestructionType.DESTROY);
        explodingEntity.discard();
        player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);

        return TypedActionResult.success(player.getStackInHand(hand));
    }
}