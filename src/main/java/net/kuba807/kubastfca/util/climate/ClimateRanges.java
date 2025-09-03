package net.kuba807.kubastfca.util.climate;


import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.RegisteredDataManager;
import net.dries007.tfc.util.climate.ClimateRange;
import net.minecraft.resources.ResourceLocation;
import net.kuba807.kubastfca.common.block.crop.Crop;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
public class ClimateRanges {

    public static final Map<Crop, Supplier<ClimateRange>> CROPS = Helpers.mapOfKeys(Crop.class, (crop) -> {
        return register("crop/" + crop.getSerializedName());
    });


    private static RegisteredDataManager.Entry<ClimateRange> register(String name) {
        return ClimateRange.MANAGER.register(new ResourceLocation("kubastfca", name.toLowerCase(Locale.ROOT)));
    }
}