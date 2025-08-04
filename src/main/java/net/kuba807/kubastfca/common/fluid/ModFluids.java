package net.kuba807.kubastfca.common.fluid;

import net.kuba807.kubastfca.common.block.ModBlocks;
import net.kuba807.kubastfca.kubastfca;
import net.kuba807.kubastfca.common.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, kubastfca.MODID);
    //teas
    public static final RegistryObject<FlowingFluid> SOURCE_TEA_goldenrod = FLUIDS.register("tea_goldenrod_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.golden_rod_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_goldenrod = FLUIDS.register("flowing_goldenrod_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.golden_rod_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_blood_lily= FLUIDS.register("tea_blood_lily_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.blood_lily_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_blood_lily= FLUIDS.register("flowing_blood_lily_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.blood_lily_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_dandelion= FLUIDS.register("tea_dandelion_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.dandelion_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_dandelion= FLUIDS.register("flowing_dandelion_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.dandelion_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_lilac= FLUIDS.register("tea_lilac_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.lilac_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_lilac= FLUIDS.register("flowing_lilac_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.lilac_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_SNAPDRAGON= FLUIDS.register("tea_snapdragon_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SNAPDRAGON_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_SNAPDRAGON= FLUIDS.register("flowing_snapdragon_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SNAPDRAGON_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_HIBISCUS= FLUIDS.register("tea_hibiscus_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HIBISCUS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_HIBISCUS= FLUIDS.register("flowing_hibiscus_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HIBISCUS_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_LABDRADOR_TEA= FLUIDS.register("tea_labrador_tea_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.LABDRADOR_TEA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_LABDRADOR_TEA= FLUIDS.register("flowing_labrador_tea_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.LABDRADOR_TEA_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_SACRED_DATURA= FLUIDS.register("tea_sacred_datura_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SACRED_DATURA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_SACRED_DATURA= FLUIDS.register("flowing_sacred_datura_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SACRED_DATURA_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_POPPY =FLUIDS.register("tea_poppy_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.POPPY_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_POPPY= FLUIDS.register("flowing_poppy_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.POPPY_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_GREEN =FLUIDS.register("green_tea_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.TEA_GREEN_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_GREEN= FLUIDS.register("flowing_green_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.TEA_GREEN_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_TEA_BLACK =FLUIDS.register("black_tea_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.TEA_BLACK_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEA_BLACK= FLUIDS.register("flowing_black_tea",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.TEA_BLACK_PROPERTIES));













    public static final ForgeFlowingFluid.Properties golden_rod_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.golden_rod, SOURCE_TEA_goldenrod, FLOWING_TEA_goldenrod)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_golden_rod_BLOCK)
            .bucket(ModItems.tea_goldenrod_bucket);

    public static final ForgeFlowingFluid.Properties blood_lily_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.blood_lily, SOURCE_TEA_blood_lily, FLOWING_TEA_blood_lily)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_blood_lily_BLOCK)
            .bucket(ModItems.tea_blood_lily_bucket);

    public static final ForgeFlowingFluid.Properties dandelion_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.dandelion, SOURCE_TEA_dandelion, FLOWING_TEA_dandelion)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_dandelion_BLOCK)
            .bucket(ModItems.tea_dandelion_bucket);

    public static final ForgeFlowingFluid.Properties lilac_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.lilac, SOURCE_TEA_lilac, FLOWING_TEA_lilac)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_lilac_BLOCK)
            .bucket(ModItems.tea_lilac_bucket);

    public static final ForgeFlowingFluid.Properties SNAPDRAGON_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SNAPDRAGON, SOURCE_TEA_SNAPDRAGON, FLOWING_TEA_SNAPDRAGON)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_SNAPDRAGON_BLOCK)
            .bucket(ModItems.TEA_SNAPDRAGON_BUCKET);

    public static final ForgeFlowingFluid.Properties HIBISCUS_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.HIBISCUS, SOURCE_TEA_HIBISCUS, FLOWING_TEA_HIBISCUS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_HIBISCUS_BLOCK)
            .bucket(ModItems.TEA_HIBISCUS_BUCKET);

    public static final ForgeFlowingFluid.Properties LABDRADOR_TEA_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.LABDRADOR_TEA, SOURCE_TEA_LABDRADOR_TEA, FLOWING_TEA_LABDRADOR_TEA)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_LABDRADOR_TEA_BLOCK)
            .bucket(ModItems.TEA_LABDRADOR_TEA_BUCKET);

    public static final ForgeFlowingFluid.Properties SACRED_DATURA_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SACRED_DATURA, SOURCE_TEA_SACRED_DATURA, FLOWING_TEA_SACRED_DATURA)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_SACRED_DATURA_BLOCK)
            .bucket(ModItems.TEA_SACRED_DATURA_BUCKET);

    public static final ForgeFlowingFluid.Properties POPPY_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.POPPY, SOURCE_TEA_POPPY, FLOWING_TEA_POPPY)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_POPPY_BLOCK)
            .bucket(ModItems.TEA_POPPY_BUCKET);

    public static final ForgeFlowingFluid.Properties TEA_GREEN_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.TEA_GREEN, SOURCE_TEA_GREEN, FLOWING_TEA_GREEN)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_GREEN_BLOCK)
            .bucket(ModItems.TEA_GREEN_BUCKET);

    public static final ForgeFlowingFluid.Properties TEA_BLACK_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.TEA_BLACK, SOURCE_TEA_BLACK, FLOWING_TEA_BLACK)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.TEA_BLACK_BLOCK)
            .bucket(ModItems.TEA_BLACK_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}