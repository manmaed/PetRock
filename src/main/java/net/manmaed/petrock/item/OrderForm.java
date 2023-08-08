package net.manmaed.petrock.item;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Created by manmaed on 25/11/2019.
 */
public class OrderForm extends Item {
    public OrderForm(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide) {
            ItemStack itemStack = player.getItemInHand(hand);
            itemStack.shrink(1);
            player.getInventory().add(new ItemStack(PRItems.PETROCKBOX.get()));
        }
        return super.use(level, player, hand);
    }
}
