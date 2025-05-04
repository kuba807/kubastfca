package net.kuba807.kubastfca.common.compat.jei;

import net.dries007.tfc.client.screen.PotScreen;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.compat.jei.transfer.FluidIgnoringRecipeTransferHandler;
import net.dries007.tfc.compat.jei.transfer.PotTransferInfo;
import net.kuba807.kubastfca.common.compat.jei.category.DumplingRecipieCategory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.ingredients.IIngredientTypeWithSubtypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.fluids.FluidStack;

import net.kuba807.kubastfca.common.recipes.KUBARecipeSerializers;
import net.kuba807.kubastfca.kubastfca;


import net.dries007.tfc.client.ClientHelpers;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.dries007.tfc.common.recipes.PotRecipe;
import net.dries007.tfc.util.Helpers;


@JeiPlugin
public class JEIIntegration implements IModPlugin{
    private static <T> RecipeType<T> type(String name, Class<T> tClass)
    {
        return RecipeType.create(kubastfca.MODID, name, tClass);
    }
    public static final IIngredientTypeWithSubtypes<Item, ItemStack> ITEM_STACK = VanillaTypes.ITEM_STACK;
    public static final IIngredientType<FluidStack> FLUID_STACK = ForgeTypes.FLUID_STACK;

    public static final RecipeType<PotRecipe> DUMPLING = type("dumpling", PotRecipe.class);




    private static <C extends Container, T extends Recipe<C>> List<T> recipes(net.minecraft.world.item.crafting.RecipeType<T> type)
    {
        return ClientHelpers.getLevelOrThrow().getRecipeManager().getAllRecipesFor(type);
    }

    private static <C extends Container, T extends Recipe<C>> List<T> recipes(net.minecraft.world.item.crafting.RecipeType<T> type, Predicate<T> filter)
    {
        return recipes(type).stream().filter(filter).collect(Collectors.toList());
    }

    private static void addRecipeCatalyst(IRecipeCatalystRegistration registry, TagKey<Item> tag, RecipeType<?> recipeType)
    {
        Helpers.allItems(tag).forEach(item -> registry.addRecipeCatalyst(new ItemStack(item), recipeType));
    }

    private static void addRecipeCatalyst(IRecipeCatalystRegistration registry, Wood.BlockType wood, RecipeType<?> recipeType)
    {
        TFCBlocks.WOODS.values().stream().map(map -> map.get(wood)).forEach(i -> registry.addRecipeCatalyst(new ItemStack(i.get()), recipeType));
    }


    @Override
    public void registerCategories(IRecipeCategoryRegistration registry)
    {
        final IGuiHelper gui = registry.getJeiHelpers().getGuiHelper();

        registry.addRecipeCategories(

                new DumplingRecipieCategory(DUMPLING, gui)
        );




}
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(kubastfca.MODID, "jei");
    }


    @Override
    public void registerRecipes(IRecipeRegistration registry)
    {
        registry.addRecipes(DUMPLING, recipes(TFCRecipeTypes.POT.get(), recipe -> recipe.getSerializer() == KUBARecipeSerializers.DUMPLING.get()));

    }


    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registry)
    {

        registry.addRecipeClickArea(PotScreen.class, 77, 6, 9, 14, DUMPLING);

    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registry)
    {
        IRecipeTransferHandlerHelper transferHelper = registry.getTransferHelper();
        registry.addRecipeTransferHandler(new FluidIgnoringRecipeTransferHandler<>(transferHelper, transferHelper.createUnregisteredRecipeTransferHandler(new PotTransferInfo(transferHelper, DUMPLING))), DUMPLING);
    }
}
