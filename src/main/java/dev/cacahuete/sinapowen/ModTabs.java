package dev.cacahuete.sinapowen;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final CreativeModeTab MOD_MAIN_TAB = new CreativeModeTab("sina") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FLAG.get());
        }
    };
}