package net.supers.test.mod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CheeseBlock extends Block {

    public static final Logger LOGGER = LoggerFactory.getLogger("superstestmod");

    public CheeseBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState blockState, PlayerEntity playerEntity) {
        playerEntity.getHungerManager().add(20, 10f);
        super.onBreak(world, pos, blockState, playerEntity);
    }
}
