package dev.cacahuete.sinapowen;

import dev.cacahuete.sinapowen.ModEntityTypes;
import dev.cacahuete.sinapowen.entity.custom.InfectionBlob;
import dev.cacahuete.sinapowen.entity.custom.MutantSpider;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = dev.cacahuete.sinapowen.Mod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event)
    {
        event.put(ModEntityTypes.MUTANT_SPIDER.get(), MutantSpider.setAttributes());
        event.put(ModEntityTypes.INFECTION_BLOB.get(), InfectionBlob.setAttributes());
    }
}
