package dev.cacahuete.sinapowen;

import dev.cacahuete.sinapowen.Mod;
import dev.cacahuete.sinapowen.entity.custom.InfectionBlob;
import dev.cacahuete.sinapowen.entity.custom.MutantSpider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Mod.ID);

    public static final RegistryObject<EntityType<MutantSpider>> MUTANT_SPIDER =
            ENTITY_TYPES.register("mutant_spider",
                    () -> EntityType.Builder.of(MutantSpider::new, MobCategory.MONSTER)
                            .sized(1.0f,1.0f)
                            .build(new ResourceLocation(Mod.ID, "mutant_spider").toString()));

    public static final RegistryObject<EntityType<InfectionBlob>> INFECTION_BLOB =
            ENTITY_TYPES.register("infection_blob",
                    () -> EntityType.Builder.of(InfectionBlob::new, MobCategory.MONSTER)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Mod.ID, "infection_blob").toString()));
    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
