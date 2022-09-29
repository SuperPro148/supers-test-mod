package supers.test.mod.mixin;

import net.minecraft.block.BarrierBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BarrierBlock.class)
public class ShowBarrierMixin {
    @Overwrite
    public BlockRenderType getRenderType(BlockState state) { return BlockRenderType.MODEL; }
}