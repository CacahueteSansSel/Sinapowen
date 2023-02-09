package dev.cacahuete.sinapowen;

import dev.cacahuete.sinapowen.entity.ModEntityTypes;
import dev.cacahuete.sinapowen.items.BatteryItem;
import dev.cacahuete.sinapowen.items.BurnableItem;
import dev.cacahuete.sinapowen.items.HealingItem;
import dev.cacahuete.sinapowen.items.PillMedicineItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mod.ID);

    public static final RegistryObject<Item> CRAB = ITEMS.register("crab",
            () -> new Item(new Item.Properties().tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> FLAG = ITEMS.register("flag",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit",
            () -> new HealingItem(20f, new Item.Properties().tab(ModTabs.MOD_MAIN_TAB).stacksTo(1)));

    public static final RegistryObject<Item> KNIFE = ITEMS.register("knife",
            () -> new SwordItem(Tiers.IRON, 1, -3f, new Item.Properties().tab(ModTabs.MOD_MAIN_TAB).durability(64)));

    public static final RegistryObject<Item> CANDY = ITEMS.register("candy",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().fast().nutrition(1).build())
                    .tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> APPETITE_SUPPRESSANT_PILL = ITEMS.register("appetite_suppressant_pill",
            () -> new Item(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().fast().saturationMod(15f).build())
                    .tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> PARACETAMOL = ITEMS.register("paracetamol_pill",
            () -> new PillMedicineItem(new Item.Properties(), "pill.sina.paracetamol", () -> new MobEffectInstance(MobEffects.REGENERATION, 500))
                    .withSideEffect(() -> new MobEffectInstance(ModEffects.LIVER_REACTION.get(), 1500)));

    public static final RegistryObject<Item> MUSIC_DISC_SINA_POLCA = ITEMS.register("music_disc_sina_polca",
            () -> new RecordItem(4, ModSounds.RECORD_SINA_POLCA,
                    new Item.Properties().tab(ModTabs.MOD_MAIN_TAB).stacksTo(1)));

    public static final RegistryObject<Item> SHEET_METAL = ITEMS.register("sheet_metal",
            () -> new Item(new Item.Properties().tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> FIRESTARTER = ITEMS.register("firestarter",
            () -> new BurnableItem(1500, new Item.Properties().tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> BATTERY_AA = ITEMS.register("battery_aa",
            () -> new BatteryItem(BatteryItem.Format.AA, new Item.Properties().tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> BATTERY_AAA = ITEMS.register("battery_aaa",
            () -> new BatteryItem(BatteryItem.Format.AAA, new Item.Properties().tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> BATTERY_C = ITEMS.register("battery_c",
            () -> new BatteryItem(BatteryItem.Format.C, new Item.Properties().tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> BATTERY_D = ITEMS.register("battery_d",
            () -> new BatteryItem(BatteryItem.Format.D, new Item.Properties().tab(ModTabs.MOD_MAIN_TAB)));

    public static final RegistryObject<Item> MUTANTSPIDER_SPAWN_EGG = ITEMS.register("mutantspider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MUTANT_SPIDER, 0x948e8d, 0x3b3635,
                    new Item.Properties().tab(ModTabs.MOD_MAIN_TAB)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
