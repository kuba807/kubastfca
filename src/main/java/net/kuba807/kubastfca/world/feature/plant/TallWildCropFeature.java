package net.kuba807.kubastfca.world.feature.plant;


import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import net.kuba807.kubastfca.common.block.crop.WildDoubleCropBlock;
import net.dries007.tfc.world.feature.BlockConfig;

public class TallWildCropFeature extends Feature<BlockConfig<WildDoubleCropBlock>>
{
    public static final Codec<BlockConfig<WildDoubleCropBlock>> CODEC = BlockConfig.codec(b -> b instanceof WildDoubleCropBlock t ? t : null, "Must be a " + WildDoubleCropBlock.class.getSimpleName());

    public TallWildCropFeature(Codec<BlockConfig<WildDoubleCropBlock>> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<BlockConfig<WildDoubleCropBlock>> context)
    {
        context.config().block().placeTwoHalves(context.level(), context.origin(), 2);
        return true;
    }
}