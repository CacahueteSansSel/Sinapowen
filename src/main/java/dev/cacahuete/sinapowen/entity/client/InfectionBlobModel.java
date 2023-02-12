package dev.cacahuete.sinapowen.entity.client;

import dev.cacahuete.sinapowen.Mod;
import dev.cacahuete.sinapowen.entity.custom.InfectionBlob;
import dev.cacahuete.sinapowen.entity.custom.MutantSpider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class InfectionBlobModel extends AnimatedGeoModel<InfectionBlob> {
    @Override
    public ResourceLocation getModelLocation(InfectionBlob object) {
        return new ResourceLocation(Mod.ID, "geo/infection_blob.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(InfectionBlob object) {
        return new ResourceLocation(Mod.ID, "textures/entity/infection_blob/infection_blob_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(InfectionBlob animatable) {
        return new ResourceLocation(Mod.ID, "animations/infection_blob.animation.json");
    }
}
