package dev.cacahuete.sinapowen.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.cacahuete.sinapowen.Mod;
import dev.cacahuete.sinapowen.entity.custom.MutantSpider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MutantSpiderRenderer extends GeoEntityRenderer<MutantSpider> {
    public MutantSpiderRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MutantSpiderModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MutantSpider instances) {
        return new ResourceLocation(Mod.ID, "textures/entity/mutant_spider/mutant_spider.png");
    }

    @Override
    public RenderType getRenderType(MutantSpider animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLighIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F,0.8F,0.8F);
        return  super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLighIn, textureLocation);
    }
}
