package dev.cacahuete.sinapowen;

import com.mojang.logging.LogUtils;
import dev.cacahuete.sinapowen.entity.ModEntityTypes;
import dev.cacahuete.sinapowen.entity.client.MutantSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@net.minecraftforge.fml.common.Mod("sina")
public class Mod {
    public static final String ID = "sina";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Mod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(bus);
        ModEffects.register(bus);
        ModItems.register(bus);
        ModSounds.register(bus);
        ModEntityTypes.register(bus);

        GeckoLib.initialize();


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        EntityRenderers.register(ModEntityTypes.MUTANT_SPIDER.get(), MutantSpiderRenderer::new);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @net.minecraftforge.fml.common.Mod.EventBusSubscriber(bus = net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

        }
    }
}
