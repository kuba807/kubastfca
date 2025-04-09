package net.kuba807.kubastfca.compat.jei;

import net.dries007.tfc.client.screen.PotScreen;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.compat.jei.transfer.FluidIgnoringRecipeTransferHandler;
import net.dries007.tfc.compat.jei.transfer.PotTransferInfo;
import net.kuba807.kubastfca.compat.jei.category.DumplingRecipieCategory;
import net.kuba807.kubastfca.recipes.DumplingRecipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.RegistryObject;

import net.kuba807.kubastfca.recipes.KUBARecipeSerializers;
import net.kuba807.kubastfca.kubastfca;


import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.client.ClientHelpers;
import net.dries007.tfc.client.screen.AnvilScreen;
import net.dries007.tfc.client.screen.BarrelScreen;
import net.dries007.tfc.client.screen.CalendarScreen;
import net.dries007.tfc.client.screen.ClimateScreen;
import net.dries007.tfc.client.screen.CrucibleScreen;
import net.dries007.tfc.client.screen.FirepitScreen;
import net.dries007.tfc.client.screen.GrillScreen;
import net.dries007.tfc.client.screen.KnappingScreen;
import net.dries007.tfc.client.screen.NutritionScreen;
import net.dries007.tfc.client.screen.PotScreen;
import net.dries007.tfc.client.screen.SewingTableScreen;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.dries007.tfc.common.container.CrucibleContainer;
import net.dries007.tfc.common.container.FirepitContainer;
import net.dries007.tfc.common.container.GrillContainer;
import net.dries007.tfc.common.container.TFCContainerTypes;
import net.dries007.tfc.common.items.TFCItems;
import net.dries007.tfc.common.recipes.AdvancedShapelessRecipe;
import net.dries007.tfc.common.recipes.AlloyRecipe;
import net.dries007.tfc.common.recipes.AnvilRecipe;
import net.dries007.tfc.common.recipes.BlastFurnaceRecipe;
import net.dries007.tfc.common.recipes.BloomeryRecipe;
import net.dries007.tfc.common.recipes.CastingRecipe;
import net.dries007.tfc.common.recipes.ChiselRecipe;
import net.dries007.tfc.common.recipes.ExtraProductsCraftingRecipe;
import net.dries007.tfc.common.recipes.GlassworkingRecipe;
import net.dries007.tfc.common.recipes.HeatingRecipe;
import net.dries007.tfc.common.recipes.InstantBarrelRecipe;
import net.dries007.tfc.common.recipes.InstantFluidBarrelRecipe;
import net.dries007.tfc.common.recipes.KnappingRecipe;
import net.dries007.tfc.common.recipes.LoomRecipe;
import net.dries007.tfc.common.recipes.PotRecipe;
import net.dries007.tfc.common.recipes.QuernRecipe;
import net.dries007.tfc.common.recipes.ScrapingRecipe;
import net.dries007.tfc.common.recipes.SealedBarrelRecipe;
import net.dries007.tfc.common.recipes.SewingRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeSerializers;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.WeldingRecipe;
import net.dries007.tfc.common.recipes.ingredients.HeatableIngredient;
import net.dries007.tfc.compat.jei.category.AlloyRecipeCategory;
import net.dries007.tfc.compat.jei.category.AnvilRecipeCategory;
import net.dries007.tfc.compat.jei.category.BlastFurnaceRecipeCategory;
import net.dries007.tfc.compat.jei.category.BloomeryRecipeCategory;
import net.dries007.tfc.compat.jei.category.CastingRecipeCategory;
import net.dries007.tfc.compat.jei.category.ChiselRecipeCategory;
import net.dries007.tfc.compat.jei.category.GlassworkingRecipeCategory;
import net.dries007.tfc.compat.jei.category.HeatingRecipeCategory;
import net.dries007.tfc.compat.jei.category.InstantBarrelRecipeCategory;
import net.dries007.tfc.compat.jei.category.InstantFluidBarrelRecipeCategory;
import net.dries007.tfc.compat.jei.category.JamPotRecipeCategory;
import net.dries007.tfc.compat.jei.category.KnappingRecipeCategory;
import net.dries007.tfc.compat.jei.category.LoomRecipeCategory;
import net.dries007.tfc.compat.jei.category.QuernRecipeCategory;
import net.dries007.tfc.compat.jei.category.ScrapingRecipeCategory;
import net.dries007.tfc.compat.jei.category.SealedBarrelRecipeCategory;
import net.dries007.tfc.compat.jei.category.SewingRecipeCategory;
import net.dries007.tfc.compat.jei.category.SimplePotRecipeCategory;
import net.dries007.tfc.compat.jei.category.SoupPotRecipeCategory;
import net.dries007.tfc.compat.jei.category.WeldingRecipeCategory;
import net.dries007.tfc.compat.jei.extension.AdvancedShapelessExtension;
import net.dries007.tfc.compat.jei.extension.ExtraProductsExtension;
import net.dries007.tfc.compat.jei.transfer.AnvilRecipeTransferHandler;
import net.dries007.tfc.compat.jei.transfer.AnvilRecipeTransferInfo;
import net.dries007.tfc.compat.jei.transfer.BarrelTransferInfo;
import net.dries007.tfc.compat.jei.transfer.FluidIgnoringRecipeTransferHandler;
import net.dries007.tfc.compat.jei.transfer.PotTransferInfo;
import net.dries007.tfc.compat.jei.transfer.WeldingRecipeTransferInfo;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.KnappingType;


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
