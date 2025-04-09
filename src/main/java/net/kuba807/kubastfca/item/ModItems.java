package net.kuba807.kubastfca.item;

import net.dries007.tfc.common.items.TFCItems;
import net.kuba807.kubastfca.fluid.ModFluids;
import net.kuba807.kubastfca.kubastfca;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, kubastfca.MODID);
    //pemmican
    public  static final RegistryObject<Item> PEMMICAN = ITEMS.register("pemmican",
            () -> new Item(new Item.Properties().food(Foods.PEMMICAN)));
    //weki



    public  static final RegistryObject<Item> MEAT_WEK= ITEMS.register("jar/meat_wek",
            () -> new Item(new Item.Properties().craftRemainder(TFCItems.JAR_LID.get().asItem())));
    public  static final RegistryObject<Item> MEAT_WEK_UNSEALED = ITEMS.register("jar/meat_wek_unsealed",
            () -> new Item(new Item.Properties().craftRemainder(TFCItems.EMPTY_JAR.get().asItem())));

    public  static final RegistryObject<Item> VEGGIE_WEK= ITEMS.register("jar/veggie_wek",
            () -> new Item(new Item.Properties().craftRemainder(TFCItems.JAR_LID.get().asItem())));
    public  static final RegistryObject<Item> VEGGIE_WEK_UNSEALED = ITEMS.register("jar/veggie_wek_unsealed",
            () -> new Item(new Item.Properties().craftRemainder(TFCItems.EMPTY_JAR.get().asItem())));

    public  static final RegistryObject<Item> MIX_WEK= ITEMS.register("jar/mix_wek",
            () -> new Item(new Item.Properties().craftRemainder(TFCItems.JAR_LID.get().asItem())));
    public  static final RegistryObject<Item> MIX_WEK_UNSEALED = ITEMS.register("jar/mix_wek_unsealed",
            () -> new Item(new Item.Properties().craftRemainder(TFCItems.EMPTY_JAR.get().asItem())));


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
    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    //wiadra herbaty, nie pytaj sam niewiem co się tu dzieje, błagam pomóż, siedze tu już kturąś godzine, jutro mam sprawdzian, a jest późno, proszę pomóż.

    public  static final RegistryObject<Item> tea_goldenrod_bucket = ITEMS.register("tea_goldenrod_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_goldenrod, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> tea_blood_lily_bucket = ITEMS.register("blood_lily_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_blood_lily, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> tea_dandelion_bucket = ITEMS.register("tea_dandelion_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TEA_dandelion, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public  static final RegistryObject<Item> tea_lilac_bucket = ITEMS.register("tea_lilac_bucket",
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

}
