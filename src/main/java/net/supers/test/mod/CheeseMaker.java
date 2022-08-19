package net.supers.test.mod;

import java.util.Set;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CheeseMaker extends Item {

    public CheeseMaker(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        if (playerEntity.getInventory().containsAny(Set.of(Items.MILK_BUCKET))) {
            
            int slot = playerEntity.getInventory().getSlotWithStack(new ItemStack(Items.MILK_BUCKET));
            playerEntity.getInventory().setStack(slot, new ItemStack(Items.BUCKET));
            playerEntity.getInventory().insertStack(new ItemStack(SupersTestMod.CHEESE));

        }
        
    return TypedActionResult.success(playerEntity.getStackInHand(hand));

    }

}