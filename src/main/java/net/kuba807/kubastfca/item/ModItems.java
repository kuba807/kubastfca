package net.kuba807.kubastfca.item;

import net.kuba807.kubastfca.kubastfca;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, kubastfca.MODID);

    public  static final RegistryObject<Item> PEMMICAN = ITEMS.register("pemmican",
            () -> new Item(new Item.Properties().food(Foods.PEMMICAN)));


    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
