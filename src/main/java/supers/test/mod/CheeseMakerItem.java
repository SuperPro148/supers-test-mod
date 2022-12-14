package supers.test.mod;

import java.util.Set;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CheeseMakerItem extends Item {

    public CheeseMakerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        if (player.getInventory().containsAny(Set.of(Items.MILK_BUCKET))) {
            
            int slot = player.getInventory().getSlotWithStack(new ItemStack(Items.MILK_BUCKET));
            player.getInventory().setStack(slot, new ItemStack(Items.BUCKET));
            player.getInventory().insertStack(new ItemStack(SupersTestMod.CHEESE));

        }
        
    return TypedActionResult.success(player.getStackInHand(hand));

    }

}