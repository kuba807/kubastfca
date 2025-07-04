package net.kuba807.kubastfca.common.block.crop;

import net.dries007.tfc.common.blockentities.CropBlockEntity;
import net.dries007.tfc.common.blockentities.FarmlandBlockEntity.NutrientType;
import net.dries007.tfc.common.blockentities.TFCBlockEntities;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.crop.DeadCropBlock;
import net.dries007.tfc.common.blocks.crop.WildCropBlock;
import net.dries007.tfc.util.climate.ClimateRange;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;



import net.kuba807.kubastfca.util.climate.ClimateRanges;

public enum Crop implements StringRepresentable
{

    // drinks
    TEA(NutrientType.NITROGEN, 8); // Default, 8


  private static ExtendedProperties doubleCrop()
  {
      return dead().blockEntity(TFCBlockEntities.CROP).serverTicks(CropBlockEntity::serverTickBottomPartOnly);
  }

    private static ExtendedProperties crop()
    {
        return dead().blockEntity(TFCBlockEntities.CROP).serverTicks(CropBlockEntity::serverTick);
    }

    private static ExtendedProperties dead()
    {
        return ExtendedProperties.of(MapColor.PLANT).noCollission().randomTicks().strength(0.4F).sound(SoundType.CROP).flammable(60, 30);
    }

    private final String serializedName;
    private final NutrientType primaryNutrient;
    private final Supplier<Block> factory;
    private final Supplier<Block> deadFactory;
    private final Supplier<Block> wildFactory;


//
  //  Crop(NutrientType primaryNutrient, int spreadingSingleBlockStages, Supplier<Supplier<? extends Block>> fruit)
  //  {
  //      this(primaryNutrient, self -> SpreadingCropBlock.create(crop(), spreadingSingleBlockStages, self, fruit), self -> new DeadCropBlock(dead(), self.getClimateRange()), self -> new WildSpreadingCropBlock(dead().randomTicks(), fruit));
  //  }
//
  //  Crop(NutrientType primaryNutrient, int spreadingSingleBlockStages, Supplier<Supplier<? extends Item>> fruit1, Supplier<Supplier<? extends Item>> fruit2)
  //  {
  //      this(primaryNutrient, self -> PickableCropBlock.create(crop(), spreadingSingleBlockStages, self, fruit1, fruit2), self -> new DeadCropBlock(dead(), self.getClimateRange()), self -> new WildCropBlock(dead().randomTicks()));
  //  }
//
  //  Crop(NutrientType primaryNutrient, int floodedSingleBlockStages, boolean flooded)
  //  {
  //      this(primaryNutrient, self -> FloodedCropBlock.create(crop(), floodedSingleBlockStages, self), self -> new FloodedDeadCropBlock(dead(), self.getClimateRange()), self -> new FloodedWildCropBlock(dead().randomTicks()));
  //      assert flooded;
  //  }

   // Crop(NutrientType primaryNutrient, int doubleBlockBottomStages, int doubleBlockTopStages, boolean requiresStick)
   // {
   //     this(primaryNutrient, requiresStick ?
   //                     self -> ClimbingCropBlock.create(doubleCrop(), doubleBlockBottomStages, doubleBlockTopStages, self) :
   //                     self -> DoubleCropBlock.create(doubleCrop(), doubleBlockBottomStages, doubleBlockTopStages, self),
   //             self -> new DeadClimbingCropBlock(dead(), self.getClimateRange()), self -> new WildDoubleCropBlock(dead().randomTicks())
   //     );
   // }
//
   Crop(NutrientType k_primaryNutrient, int k_singleBlockStages)
   {
       this(k_primaryNutrient, self -> KubaDefaultCropBlock.create(crop(), k_singleBlockStages, self), self -> new DeadCropBlock(dead(), self.getClimateRange()), self -> new WildCropBlock(dead().randomTicks()));
   }

    Crop(NutrientType k_primaryNutrient, Function<Crop, Block> k_factory, Function<Crop, Block> k_deadFactory, Function<Crop, Block> k_wildFactory)
    {
        this.serializedName = name().toLowerCase(Locale.ROOT);
        this.primaryNutrient = k_primaryNutrient;
        this.factory = () -> k_factory.apply(this);
        this.deadFactory = () -> k_deadFactory.apply(this);
        this.wildFactory = () -> k_wildFactory.apply(this);
    }
    @Override
    public String getSerializedName()
    {
        return serializedName;
    }

    public Block create()
    {
        return factory.get();
    }

    public Block createDead()
    {
        return deadFactory.get();
    }

    public Block createWild()
    {
        return wildFactory.get();
    }

    public NutrientType getPrimaryNutrient()
    {
        return primaryNutrient;
    }

    public Supplier<ClimateRange> getClimateRange()
    {
        return ClimateRanges.CROPS.get(this);
    }

}