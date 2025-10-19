package com.matatabi.matatabiMod.items;

import com.matatabi.matatabiMod.registry.tag.MatatabiModTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;


public class TestItem extends Item {
    public TestItem() {
        super(new Properties()
                .rarity(Rarity.EPIC)
                .stacksTo(64)

        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.is(MatatabiModTags.Items.MATATABI_ITEMS)){
            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20*5,0));
        }else {
            player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20*5,0));
        }
        return InteractionResultHolder.consume(stack);
    }
}
