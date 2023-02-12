package dev.cacahuete.sinapowen.event.loot;

import dev.cacahuete.sinapowen.ModEntityTypes;
import dev.cacahuete.sinapowen.entity.custom.InfectionBlob;
import dev.cacahuete.sinapowen.entity.custom.MutantSpider;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = dev.cacahuete.sinapowen.Mod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {


    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event)
    {
        event.put(ModEntityTypes.MUTANT_SPIDER.get(), MutantSpider.setAttributes());
        event.put(ModEntityTypes.INFECTION_BLOB.get(), InfectionBlob.setAttributes());
    }

}
