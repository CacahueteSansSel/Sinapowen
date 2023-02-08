package dev.cacahuete.sinapowen.items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BatteryItem extends Item {
    Format format;

    public BatteryItem(Format format, Properties properties) {
        super(properties);

        this.format = format;
    }

    @Override
    public @NotNull String getDescriptionId() {
        return "item.sina.battery";
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flags) {
        if (format != null) components.add(new TextComponent(format.name));
        super.appendHoverText(stack, level, components, flags);
    }

    public enum Format {
        AA("AA"),
        AAA("AAA"),
        C("C"),
        D("D"),
        LR12("LR12"),
        RC22("RC22"),
        LR25("LR25")
        ;

        public final String name;

        Format(String name) {
            this.name = name;
        }
    }
}