package net.kuba807.kubastfca.client;

import net.dries007.tfc.client.IGhostBlockHandler;
import net.dries007.tfc.client.TFCColors;
import net.dries007.tfc.client.model.ContainedFluidModel;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.kuba807.kubastfca.kubastfca;
import net.kuba807.kubastfca.common.block.ModBlocks;

import java.util.function.Predicate;

public class ClientEventHandler {

    public static void init() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ClientEventHandler::registerColorHandlerBlocks);
        bus.addListener(ClientEventHandler::registerColorHandlerItems);
    }

    public static void registerColorHandlerBlocks(RegisterColorHandlersEvent.Block event) {
        final BlockColor grassColor = (state, level, pos, tintIndex) -> TFCColors.getGrassColor(pos, tintIndex);
        ModBlocks.WILD_CROPS.forEach((crop, reg) -> event.register(grassColor, reg.get()));
    }

    public static void registerColorHandlerItems(RegisterColorHandlersEvent.Item event) {
        final ItemColor grassColor = (stack, tintIndex) -> TFCColors.getGrassColor(null, tintIndex);

        ModBlocks.WILD_CROPS.forEach((key, value) -> event.register(grassColor, value.get().asItem()));



    }

}
