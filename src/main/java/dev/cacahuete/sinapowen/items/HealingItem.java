package dev.cacahuete.sinapowen.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HealingItem extends Item {
    float amount;

    public HealingItem(float amount, Properties props) {
        super(props);

        this.amount = amount;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.heal(amount);

        // TODO: Sound effect

        return InteractionResultHolder.consume(ItemStack.EMPTY);
    }
}
