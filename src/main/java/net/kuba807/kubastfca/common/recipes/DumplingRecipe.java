package net.kuba807.kubastfca.common.recipes;

import net.kuba807.kubastfca.common.item.ModItems;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonObject;
import net.dries007.tfc.common.recipes.PotRecipe;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import net.dries007.tfc.common.blockentities.PotBlockEntity;
import net.dries007.tfc.common.capabilities.food.DynamicBowlHandler;
import net.dries007.tfc.common.capabilities.food.FoodCapability;
import net.dries007.tfc.common.capabilities.food.FoodData;
import net.dries007.tfc.common.capabilities.food.IFood;
import net.dries007.tfc.common.capabilities.food.Nutrient;
import net.dries007.tfc.common.fluids.TFCFluids;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.dries007.tfc.compat.jade.common.BlockEntityTooltip;

public class DumplingRecipe extends PotRecipe
{
    public static final OutputType OUTPUT_TYPE = nbt -> {
        ItemStack stack = ItemStack.of(nbt.getCompound("item"));
        return new SoupOutput(stack);
    };

    public static final int SOUP_HUNGER_VALUE = 4;
    public static final float SOUP_DECAY_MODIFIER = 3.5F;

    public DumplingRecipe(ResourceLocation id, List<Ingredient> itemIngredients, FluidStackIngredient fluidIngredient, int duration, float minTemp)
    {
        super(id, itemIngredients, fluidIngredient, duration, minTemp);
    }

    @Override
    public Output getOutput(PotBlockEntity.PotInventory inventory)
    {
        int ingredientCount = 0;
        float water = 20, saturation = 2;
        float[] nutrition = new float[Nutrient.TOTAL];
        ItemStack soupStack = ItemStack.EMPTY;
        final List<ItemStack> itemIngredients = new ArrayList<>();
        for (int i = PotBlockEntity.SLOT_EXTRA_INPUT_START; i <= PotBlockEntity.SLOT_EXTRA_INPUT_END; i++)
        {
            final ItemStack stack = inventory.getStackInSlot(i);
            final @Nullable IFood food = FoodCapability.get(stack);
            if (food != null)
            {
                itemIngredients.add(stack);
                if (food.isRotten()) // this should mostly not happen since the ingredients are not rotten to start, but worth checking
                {
                    ingredientCount = 0;
                    break;
                }
                final FoodData data = food.getData();
                water += data.water();
                saturation += data.saturation();
                for (Nutrient nutrient : Nutrient.VALUES)
                {
                    nutrition[nutrient.ordinal()] += data.nutrient(nutrient);
                }
                ingredientCount++;
            }
        }
        if (ingredientCount > 0)
        {
            for (int i = 0; i < nutrition.length; i++) {
                nutrition[i]=nutrition[i]/ingredientCount;
            }

            water =water/ingredientCount; saturation =saturation/ingredientCount;
            FoodData data = FoodData.create(SOUP_HUNGER_VALUE, water, saturation, nutrition, SOUP_DECAY_MODIFIER);
            int servings = (int) (ingredientCount) ;
            long created = FoodCapability.getRoundedCreationDate();

            soupStack = new ItemStack(ModItems.COOKED_DUMPLING.get(), servings);
            final @Nullable IFood food = FoodCapability.get(soupStack);
            if (food instanceof DynamicBowlHandler handler)
            {
                handler.setCreationDate(created);

                handler.setFood(data);
            }
        }

        return new SoupOutput(soupStack);
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return KUBARecipeSerializers.DUMPLING.get();
    }

    public record SoupOutput(ItemStack stack) implements Output
    {
        @Override
        public boolean isEmpty()
        {
            return stack.isEmpty();
        }

        @Override
        public InteractionResult onInteract(PotBlockEntity entity, Player player, ItemStack clickedWith)
        {
            if (!stack.isEmpty())
            {
                ItemHandlerHelper.giveItemToPlayer(player, stack.split(1));
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }

        @Override
        public int getFluidColor()
        {
            return TFCFluids.ALPHA_MASK | 0x124214;
        }

        @Override
        public void write(CompoundTag nbt)
        {
            nbt.put("item", stack.save(new CompoundTag()));
        }

        @Override
        public OutputType getType()
        {
            return DumplingRecipe.OUTPUT_TYPE;
        }

        @Override
        public BlockEntityTooltip getTooltip()
        {
            return ((level, state, pos, entity, tooltip) -> {
                final List<Component> text = new ArrayList<>();
                FoodCapability.addTooltipInfo(stack, text);

                text.forEach(tooltip);
            });
        }
    }

    public static class Serializer extends PotRecipe.Serializer<DumplingRecipe>
    {
        @Override
        protected DumplingRecipe fromJson(ResourceLocation recipeId, JsonObject json, List<Ingredient> ingredients, FluidStackIngredient fluidIngredient, int duration, float minTemp)
        {
            return new DumplingRecipe(recipeId, ingredients, fluidIngredient, duration, minTemp);
        }

        @Override
        protected DumplingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer, List<Ingredient> ingredients, FluidStackIngredient fluidIngredient, int duration, float minTemp)
        {
            return new DumplingRecipe(recipeId, ingredients, fluidIngredient, duration, minTemp);
        }
    }
}