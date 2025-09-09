package net.kuba807.kubastfca.world.feature;

import net.kuba807.kubastfca.world.feature.plant.TallWildCropFeature;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import static net.kuba807.kubastfca.kubastfca.*;

public class kubafeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MODID);

    public static final RegistryObject<TallWildCropFeature> TALL_WILD_CROP = register("tall_wild_crop", TallWildCropFeature::new, TallWildCropFeature.CODEC);

    private static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<F> register(String name, Function<Codec<C>, F> factory, Codec<C> codec)
    {
        return FEATURES.register(name, () -> factory.apply(codec));
    }
}
