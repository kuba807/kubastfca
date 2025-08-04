package net.kuba807.kubastfca.common.block;

import net.kuba807.kubastfca.common.block.crop.Crop;
import net.kuba807.kubastfca.common.item.ModItems;
import net.kuba807.kubastfca.kubastfca;
import net.kuba807.kubastfca.common.fluid.ModFluids;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
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

    public static final RegistryObject<LiquidBlock> TEA_POPPY_BLOCK = BLOCKS.register("tea_poppy_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_POPPY ,BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_GREEN_BLOCK = BLOCKS.register("tea_green_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_GREEN ,BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> TEA_BLACK_BLOCK = BLOCKS.register("tea_black_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TEA_BLACK ,BlockBehaviour.Properties.copy(Blocks.WATER)));
        //uprawy
        public static final Map<Crop, RegistryObject<Block>> CROPS = Helpers.mapOfKeys(Crop.class, crop ->
                BLOCKS.register("crop/" + crop.getSerializedName(), crop::create));

        public static final Map<Crop, RegistryObject<Block>> DEAD_CROPS = Helpers.mapOfKeys(Crop.class, crop ->
            BLOCKS.register("dead_crop/" + crop.getSerializedName(), crop::createDead));
        public static final Map<Crop, RegistryObject<Block>> WILD_CROPS = Helpers.mapOfKeys(Crop.class, crop ->
            BLOCKS.register("wild_crop/" + crop.getSerializedName(), crop::createWild));


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
