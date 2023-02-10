package dev.cacahuete.sinapowen.entity.client;

import dev.cacahuete.sinapowen.Mod;
import dev.cacahuete.sinapowen.entity.custom.MutantSpider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MutantSpiderModel extends AnimatedGeoModel<MutantSpider> {
    @Override
    public ResourceLocation getModelLocation(MutantSpider object) {
        return new ResourceLocation(Mod.ID, "geo/mutantspider.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MutantSpider object) {
        return new ResourceLocation(Mod.ID, "textures/entity/mutantspider/mutantspider.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MutantSpider animatable) {
        return new ResourceLocation(Mod.ID, "animations/mutantspider.animation.json");
    }
}
