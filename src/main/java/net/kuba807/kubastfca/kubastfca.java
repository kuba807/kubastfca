package net.kuba807.kubastfca;

import net.kuba807.kubastfca.common.block.crop.Crop;
import net.kuba807.kubastfca.common.fluid.ModFluidTypes;
import net.kuba807.kubastfca.common.fluid.ModFluids;
import com.mojang.logging.LogUtils;
import net.kuba807.kubastfca.common.item.ModItems;
import net.kuba807.kubastfca.common.block.ModBlocks;
import net.kuba807.kubastfca.common.recipes.KUBARecipeSerializers;
import net.kuba807.kubastfca.client.ClientEventHandler;

import net.minecraft.client.Minecraft;


import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(kubastfca.MODID)
public class kubastfca
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "kubastfca";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public kubastfca()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        //fluid
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientEventHandler.init();
        }

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        KUBARecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");


    }
    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey()== CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.PEMMICAN);
            event.accept(ModItems.DUMPLING);
            event.accept(ModItems.COOKED_DUMPLING);
            event.accept(ModItems.RAW_PASTA);
            event.accept(ModItems.PASTA);
            event.accept(ModItems.MEAT_WEK);
            event.accept(ModItems.MEAT_WEK_UNSEALED);
            event.accept(ModItems.VEGGIE_WEK);
            event.accept(ModItems.VEGGIE_WEK_UNSEALED);
            event.accept(ModItems.MIX_WEK);
            event.accept(ModItems.MIX_WEK_UNSEALED);
            event.accept(ModItems.GREEN_TEA_LEAVES);

        }
}

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_TEA_goldenrod.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_TEA_goldenrod.get(), RenderType.translucent());

            for (Crop crop : Crop.values()) {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.CROPS.get(crop).get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEAD_CROPS.get(crop).get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CROPS.get(crop).get(), RenderType.cutout());
            }
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
