package net.kuba807.kubastfca.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class
Foods {
    public static final FoodProperties PEMMICAN = new FoodProperties.Builder().nutrition(4).saturationMod(0.1f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 100),0.03f).build();
<<<<<<< Updated upstream
    public static final FoodProperties DEFAULT = new FoodProperties.Builder().nutrition(0).saturationMod(0f).build();
=======
    public static final FoodProperties DEFAULT = new FoodProperties.Builder().nutrition(4).saturationMod(0f).build();
    public static final FoodProperties RAW = new FoodProperties.Builder().nutrition(0).saturationMod(0.0f).effect(() -> new MobEffectInstance(MobEffects.POISON, 100),0.1f).build();
>>>>>>> Stashed changes
}
