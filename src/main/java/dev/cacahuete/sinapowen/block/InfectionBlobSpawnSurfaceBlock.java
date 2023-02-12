package dev.cacahuete.sinapowen.block;

import net.minecraft.world.level.block.Block;

public class InfectionBlobSpawnSurfaceBlock extends Block {
    public InfectionBlobSpawnSurfaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public float getSpeedFactor() {
        return 0.4f;
    }
}
