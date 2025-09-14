package net.kuba807.kubastfca.common.item;


import net.dries007.tfc.util.Helpers;
import net.kuba807.kubastfca.common.block.ModBlocks;
import net.kuba807.kubastfca.common.block.crop.Crop;

import net.dries007.tfc.common.items.JarItem;
import net.kuba807.kubastfca.common.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

import static net.kuba807.kubastfca.kubastfca.MODID;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    //pemmican
    public  static final RegistryObject<Item> PEMMICAN = ITEMS.register("pemmican",
            () -> new Item(new Item.Properties().food(Foods.PEMMICAN)));
    //weki



    public  static final RegistryObject<Item> MEAT_WEK= ITEMS.register("jar/meat_wek",
            () -> new JarItem(new Item.Properties(), "peach", false));
    public  static final RegistryObject<Item> MEAT_WEK_UNSEALED = ITEMS.register("jar/meat_wek_unsealed",
            () -> new JarItem(new Item.Properties(), "peach_unsealed", true));

    public  static final RegistryObject<Item> VEGGIE_WEK= ITEMS.register("jar/veggie_wek",
            () -> new JarItem(new Item.Properties(), "olive", false));
    public  static final RegistryObject<Item> VEGGIE_WEK_UNSEALED = ITEMS.register("jar/veggie_wek_unsealed",
            () -> new JarItem(new Item.Properties(), "olive_unsealed", true));

    public  static final RegistryObject<Item> MIX_WEK= ITEMS.register("jar/mix_wek",
            () -> new JarItem(new Item.Properties(), "pumpkin_chunks", false));
    public  static final RegistryObject<Item> MIX_WEK_UNSEALED = ITEMS.register("jar/mix_wek_unsealed",
            () -> new JarItem(new Item.Properties(), "pumpkin_chunks_unsealed", true));


    //pierogi
    public  static final RegistryObject<Item> DUMPLING = ITEMS.register("dumpling",
            () -> new Item(new Item.Properties().food(Foods.RAW)));

    public  static final RegistryObject<Item> COOKED_DUMPLING = ITEMS.register("cooked_dumpling",
            () -> new Item(new Item.Properties().food(Foods.DEFAULT)));

    //makaron
    public  static final RegistryObject<Item> PASTA = ITEMS.register("pasta",
            () -> new Item(new Item.Properties().food(Foods.DEFAULT)));
    public  static final RegistryObject<Item> RAW_PASTA = ITEMS.register("raw_pasta",
            () -> new Item(new Item.Properties().food(Foods.RAW)));

    //makowiec
    public  static final RegistryObject<Item> poppy_roll = ITEMS.register("poppy_roll",
            () -> new Item(new Item.Properties().food(Foods.DEFAULT)));
    public  static final RegistryObject<Item> RAW_poppy_roll = ITEMS.register("raw_poppy_roll",
            () -> new Item(new Item.Properties().food(Foods.RAW)));

    //wiadra herbaty, nie pytaj sam niewiem co się tu dzieje, błagam pomóż, siedze tu już kturąś godzine, a jest późno, proszę pomóż.

    public  static final RegistryObject<Item> TEA_GOLDENROD_BUCKET = ITEMS.register("tea_goldenrod_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_goldenrod, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_BLOOD_LILY_BUCKET = ITEMS.register("blood_lily_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_blood_lily, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_DANDELION_BUCKET = ITEMS.register("tea_dandelion_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_dandelion, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_LILAC_BUCKET = ITEMS.register("tea_lilac_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_lilac, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_SNAPDRAGON_BUCKET = ITEMS.register("tea_snapdragon_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_SNAPDRAGON, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_HIBISCUS_BUCKET = ITEMS.register("tea_hibiscus_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_HIBISCUS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_LABDRADOR_TEA_BUCKET = ITEMS.register("tea_labrador_tea_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_LABDRADOR_TEA, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_SACRED_DATURA_BUCKET = ITEMS.register("tea_sacred_datura_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_SACRED_DATURA, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_POPPY_BUCKET = ITEMS.register("tea_poppy_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_POPPY, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_GREEN_BUCKET = ITEMS.register("green_tea_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_GREEN, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> TEA_BLACK_BUCKET = ITEMS.register("black_tea_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_BLACK, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> SUNFLOWER_OIL_BUCKET = ITEMS.register("sunflower_oil_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SUNFLOWER_OIL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> SUNFLOWER_OIL_WATER_BUCKET = ITEMS.register("sunflower_oil_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SUNFLOWER_OIL_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    //organiczne, nie gnijące, contains special preservatives
    public  static final RegistryObject<Item> GREEN_TEA_LEAVES = ITEMS.register("green_tea_leaves",
            () -> new Item(new Item.Properties()));
    public  static final RegistryObject<Item> BLACK_TEA_LEAVES = ITEMS.register("black_tea_leaves",
            () -> new Item(new Item.Properties()));
    //organiczne, gnijące
    public  static final RegistryObject<Item> SUNFLOWER_SEEDS = ITEMS.register("sunflower_seeds",
            () -> new Item(new Item.Properties().food(Foods.DEFAULT)));
    public  static final RegistryObject<Item> SUNFLOWER_pulp = ITEMS.register("sunflower_pulp",
            () -> new Item(new Item.Properties().food(Foods.DEFAULT)));

    //rosliny
    public static final Map<Crop, RegistryObject<Item>> CROP_SEEDS = Helpers.mapOfKeys(Crop.class, crop ->
            ITEMS.register("seeds/" + crop.getSerializedName(), () -> new ItemNameBlockItem(ModBlocks.CROPS.get(crop).get(), new Item.Properties())));

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }



}
