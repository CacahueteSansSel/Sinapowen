package dev.cacahuete.sinapowen.world;

import dev.cacahuete.sinapowen.world.gen.ModEntityGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = dev.cacahuete.sinapowen.Mod.ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        ModEntityGeneration.onEntitySpawn(event);
    }

}
