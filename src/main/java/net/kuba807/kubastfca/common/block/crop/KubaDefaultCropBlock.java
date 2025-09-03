package net.kuba807.kubastfca.common.block.crop;


import java.util.function.Supplier;

import net.dries007.tfc.common.blockentities.CropBlockEntity;
import net.dries007.tfc.common.blocks.crop.DefaultCropBlock;
import net.kuba807.kubastfca.common.block.ModBlocks;
import net.kuba807.kubastfca.common.item.ModItems;
import net.kuba807.kubastfca.util.climate.ClimateRanges;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import net.dries007.tfc.common.blockentities.FarmlandBlockEntity;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.TFCBlockStateProperties;
import net.dries007.tfc.util.climate.ClimateRange;


public abstract class KubaDefaultCropBlock extends KubaCropBlock
{
    public static KubaDefaultCropBlock create(ExtendedProperties properties, int stages, Crop crop)
    {
        final IntegerProperty property = TFCBlockStateProperties.getAgeProperty(stages - 1);
        return new KubaDefaultCropBlock(properties, stages - 1, ModBlocks.DEAD_CROPS.get(crop), ModItems.CROP_SEEDS.get(crop), crop.getPrimaryNutrient(), ClimateRanges.CROPS.get(crop))
        {
            @Override
            public IntegerProperty getAgeProperty()
            {
                return property;
            }
        };
    }

    protected KubaDefaultCropBlock(ExtendedProperties properties, int maxAge, Supplier<? extends Block> dead, Supplier<? extends Item> seeds, FarmlandBlockEntity.NutrientType primaryNutrient, Supplier<ClimateRange> climateRange)
    {
        super(properties, maxAge, dead, seeds, primaryNutrient, climateRange);
    }

    @Override
    public void die(Level level, BlockPos pos, BlockState state, boolean fullyGrown)
    {
        final BlockState deadState = dead.get().defaultBlockState().setValue(DeadCropBlock.MATURE, fullyGrown);
        level.setBlockAndUpdate(pos, deadState);
    }

    @Override
    protected void postGrowthTick(Level level, BlockPos pos, BlockState state, CropBlockEntity crop)
    {
        final int age = crop.getGrowth() == 1 ? getMaxAge() : (int) (crop.getGrowth() * getMaxAge());
        level.setBlockAndUpdate(pos, state.setValue(getAgeProperty(), age));
    }
}