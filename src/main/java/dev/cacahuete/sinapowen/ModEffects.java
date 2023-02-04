package dev.cacahuete.sinapowen;

import dev.cacahuete.sinapowen.effects.LiverReactionEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Mod.ID);

    public static final RegistryObject<MobEffect> LIVER_REACTION = EFFECTS.register("liver_reaction",
            () -> new LiverReactionEffect(MobEffectCategory.HARMFUL, 4990992));

    public static void register(IEventBus bus) {
        EFFECTS.register(bus);
    }
}
