package net.kuba807.kubastfca.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Foods {
    public static final FoodProperties PEMMICAN = new FoodProperties.Builder().nutrition(4).saturationMod(0.1f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 100),0.03f).build();
}
