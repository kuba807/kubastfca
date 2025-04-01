package net.kuba807.kubastfca.block;

import net.kuba807.kubastfca.item.ModItems;
import net.kuba807.kubastfca.kubastfca;
import net.kuba807.kubastfca.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, kubastfca.MODID);

    public static final RegistryObject<LiquidBlock> TEA_golden_rod_BLOCK = BLOCKS.register("tea_golden_rod_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_goldenrod, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_blood_lily_BLOCK = BLOCKS.register("tea_blood_lily_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_blood_lily, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_dandelion_BLOCK = BLOCKS.register("tea_dandelion_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_dandelion, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_lilac_BLOCK = BLOCKS.register("tea_lilac_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_lilac, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_SNAPDRAGON_BLOCK = BLOCKS.register("tea_snapdragon_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_SNAPDRAGON, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_HIBISCUS_BLOCK = BLOCKS.register("tea_hibiscus_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_HIBISCUS, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_LABDRADOR_TEA_BLOCK = BLOCKS.register("tea_labrador_tea_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_LABDRADOR_TEA ,BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_SACRED_DATURA_BLOCK = BLOCKS.register("tea_sacred_datura_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_SACRED_DATURA ,BlockBehaviour.Properties.copy(Blocks.WATER)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
}}
