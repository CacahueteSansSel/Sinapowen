package dev.cacahuete.sinapowen.items;

import dev.cacahuete.sinapowen.ModTabs;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class PillMedicineItem extends Item {
    Supplier<MobEffectInstance> appliedEffect;
    Supplier<MobEffectInstance> sideEffect = null;
    String nameTranslationKey;

    public PillMedicineItem(Properties prop, String nameTranslationKey, Supplier<MobEffectInstance> effect) {
        super(prop.food(new FoodProperties.Builder().fast().effect(effect, 1f).alwaysEat().build()).stacksTo(16)
                .tab(ModTabs.MOD_MAIN_TAB));

        this.nameTranslationKey = nameTranslationKey;
        this.appliedEffect = effect;
    }

    public PillMedicineItem withSideEffect(Supplier<MobEffectInstance> sideEffect) {
        this.sideEffect = sideEffect;

        return this;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (sideEffect == null) return super.finishUsingItem(stack, level, entity);

        boolean hadEffect = false;

        if (entity.hasEffect(appliedEffect.get().getEffect()) && level.random.nextFloat() < 0.4f) {
            entity.addEffect(sideEffect.get());
            hadEffect = true;
        }

        ItemStack finalStack = super.finishUsingItem(stack, level, entity);

        if (hadEffect) {
            entity.removeEffect(appliedEffect.get().getEffect());
        }

        return finalStack;
    }

    @Override
    public @NotNull String getDescriptionId() {
        return "item.sina.pill";
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flags) {
        components.add(new TranslatableComponent(nameTranslationKey));
        components.add(appliedEffect.get().getEffect().getDisplayName());
        components.add(new TextComponent(appliedEffect.get().getDuration() + "s").withStyle(ChatFormatting.ITALIC));

        super.appendHoverText(stack, level, components, flags);
    }
}
