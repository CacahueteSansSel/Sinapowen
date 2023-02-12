package dev.cacahuete.sinapowen.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TransparentBlock extends HalfTransparentBlock {
    public TransparentBlock(Properties properties) {
        super(properties.noOcclusion().isValidSpawn((u, v, x, y) -> false)
                .isRedstoneConductor((u, v, x) -> false).isSuffocating((u, v, x) -> false)
                .isViewBlocking((u, v, x) -> false));
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter get, BlockPos pos, CollisionContext ctx) {
        return Shapes.empty();
    }

    @Override
    public float getShadeBrightness(BlockState state, BlockGetter get, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter get, BlockPos pos) {
        return true;
    }
}
