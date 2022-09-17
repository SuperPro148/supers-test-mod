package supers.test.mod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DynamiteItem extends Item {

    public DynamiteItem(Settings settings) {
        super(settings); 
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient()) {

            DynamiteEntity dynamiteEntity = new DynamiteEntity(world, user);
            dynamiteEntity.setItem(itemStack);
            dynamiteEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, .75f, 2.0f);
            world.spawnEntity(dynamiteEntity);

        }

        itemStack.decrement(1);

        return TypedActionResult.success(itemStack);

    }
    
}
