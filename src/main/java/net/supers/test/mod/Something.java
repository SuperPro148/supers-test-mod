package net.supers.test.mod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Something extends Item {

    public static final Logger LOGGER = LoggerFactory.getLogger("superstestmod");

    public Something(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        LOGGER.info("item used lel");
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

}