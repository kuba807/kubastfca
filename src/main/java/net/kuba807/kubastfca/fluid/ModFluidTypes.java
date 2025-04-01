package net.kuba807.kubastfca.fluid;

import  net.kuba807.kubastfca.kubastfca;
import net.minecraft.sounds.SoundEvents;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");
//test - do usunięcia
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, kubastfca.MODID);

    public static final RegistryObject<FluidType> tea = register("tea",
            FluidType.Properties.create()
                    .adjacentPathType(BlockPathTypes.WATER)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .canConvertToSource(true)
                    .canDrown(true)
                    .canExtinguish(true)
                    .canHydrate(false)
                    .canPushEntity(true)
                    .canSwim(true)
                    .supportsBoating(true));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                0xFF246b1b, new Vector3f(100f / 255f, 100f / 255f, 100f / 255f), properties));
    }

    //herbaty
        public static final RegistryObject<FluidType> golden_rod = registerFluidType("golden_rod",
                new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xF0fada5e,
                        new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                        FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).adjacentPathType(BlockPathTypes.WATER)
                                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                                .canConvertToSource(true)
                                .canDrown(true)
                                .canExtinguish(true)
                                .canHydrate(false)
                                .canPushEntity(true)
                                .canSwim(true)
                                .supportsBoating(true)
                ));
    public static final RegistryObject<FluidType> blood_lily = registerFluidType("blood_lily",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xF0fa003a,
                    new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).adjacentPathType(BlockPathTypes.WATER)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .canConvertToSource(true)
                            .canDrown(true)
                            .canExtinguish(true)
                            .canHydrate(false)
                            .canPushEntity(true)
                            .canSwim(true)
                            .supportsBoating(true)
            ));
    public static final RegistryObject<FluidType> dandelion = registerFluidType("dandelion",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xF0fada5e,
                    new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).adjacentPathType(BlockPathTypes.WATER)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .canConvertToSource(true)
                            .canDrown(true)
                            .canExtinguish(true)
                            .canHydrate(false)
                            .canPushEntity(true)
                            .canSwim(true)
                            .supportsBoating(true)
            ));
    public static final RegistryObject<FluidType> lilac = registerFluidType("lilac",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xF0ff0065,
                    new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).adjacentPathType(BlockPathTypes.WATER)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .canConvertToSource(true)
                            .canDrown(true)
                            .canExtinguish(true)
                            .canHydrate(false)
                            .canPushEntity(true)
                            .canSwim(true)
                            .supportsBoating(true)
            ));
    public static final RegistryObject<FluidType> SNAPDRAGON = registerFluidType("snapdragon",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xF09fbd6f,
                    new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).adjacentPathType(BlockPathTypes.WATER)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .canConvertToSource(true)
                            .canDrown(true)
                            .canExtinguish(true)
                            .canHydrate(false)
                            .canPushEntity(true)
                            .canSwim(true)
                            .supportsBoating(true)
            ));
    public static final RegistryObject<FluidType> HIBISCUS = registerFluidType("hibiscus",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xF0c21212,
                    new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).adjacentPathType(BlockPathTypes.WATER)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .canConvertToSource(true)
                            .canDrown(true)
                            .canExtinguish(true)
                            .canHydrate(false)
                            .canPushEntity(true)
                            .canSwim(true)
                            .supportsBoating(true)
            ));
    public static final RegistryObject<FluidType> LABDRADOR_TEA = registerFluidType("labrador_tea",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xF0c8c211,
                    new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).adjacentPathType(BlockPathTypes.WATER)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .canConvertToSource(true)
                            .canDrown(true)
                            .canExtinguish(true)
                            .canHydrate(false)
                            .canPushEntity(true)
                            .canSwim(true)
                            .supportsBoating(true)
            ));

    public static final RegistryObject<FluidType> SACRED_DATURA = registerFluidType("sacred_datura",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xF0c8c211,
                    new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).adjacentPathType(BlockPathTypes.WATER)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                            .canConvertToSource(true)
                            .canDrown(true)
                            .canExtinguish(true)
                            .canHydrate(false)
                            .canPushEntity(true)
                            .canSwim(true)
                            .supportsBoating(true)
            ));


    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}