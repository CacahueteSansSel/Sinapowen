package dev.cacahuete.sinapowen.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.cacahuete.sinapowen.Mod;
import dev.cacahuete.sinapowen.entity.custom.InfectionBlob;
import dev.cacahuete.sinapowen.entity.custom.MutantSpider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class InfectionBlobRenderer extends GeoEntityRenderer<InfectionBlob> {
    public InfectionBlobRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new InfectionBlobModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull InfectionBlob instances) {
        return new ResourceLocation(Mod.ID, "textures/entity/infection_blob/infection_blob_texture.png");
    }

    @Override
    public RenderType getRenderType(InfectionBlob animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
