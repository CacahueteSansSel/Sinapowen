package dev.cacahuete.sinapowen.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RFPoleBlock extends FaceAttachedHorizontalDirectionalBlock {
    protected static final VoxelShape FLOOR_SHAPE
            = Block.box(3, 0, 3, 13, 7, 13);
    protected static final VoxelShape CEILING_SHAPE
            = Block.box(3, 9, 3, 13, 16, 13);
    protected static final VoxelShape SIDE_NORTH_SHAPE
            = Block.box(3, 3, 9, 13, 13, 16);
    protected static final VoxelShape SIDE_SOUTH_SHAPE
            = Block.box(3, 3, 0, 13, 13, 7);
    protected static final VoxelShape SIDE_EAST_SHAPE
            = Block.box(0, 3, 3, 7, 13, 13);
    protected static final VoxelShape SIDE_WEST_SHAPE
            = Block.box(9, 3, 3, 16, 13, 13);
    public RFPoleBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
                .setValue(FACE, AttachFace.WALL));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51101_) {
        p_51101_.add(FACING, FACE);
    }

    public VoxelShape getShape(BlockState state, BlockGetter get, BlockPos pos, CollisionContext collisionCtx) {
        AttachFace face = state.getValue(FACE);
        Direction dir = state.getValue(FACING);

        switch (face) {
            case FLOOR -> {
                return FLOOR_SHAPE;
            }
            case WALL -> {
                switch (dir) {
                    case DOWN -> {
                        return FLOOR_SHAPE;
                    }
                    case UP -> {
                        return CEILING_SHAPE;
                    }
                    case NORTH -> {
                        return SIDE_NORTH_SHAPE;
                    }
                    case SOUTH -> {
                        return SIDE_SOUTH_SHAPE;
                    }
                    case WEST -> {
                        return SIDE_WEST_SHAPE;
                    }
                    case EAST -> {
                        return SIDE_EAST_SHAPE;
                    }
                }
            }
            case CEILING -> {
                return CEILING_SHAPE;
            }
        }
        return CEILING_SHAPE;
    }
}
