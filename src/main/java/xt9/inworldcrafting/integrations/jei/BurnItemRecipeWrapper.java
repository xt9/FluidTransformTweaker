package xt9.inworldcrafting.integrations.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import xt9.inworldcrafting.InWorldCrafting;
import xt9.inworldcrafting.common.recipe.BurnItemRecipe;
import xt9.inworldcrafting.common.util.IngredientHelper;
import net.minecraft.client.resources.I18n;

/**
 * Created by xt9 on 2019-01-20.
 */
public class BurnItemRecipeWrapper implements IRecipeWrapper {
    private BurnItemRecipe recipe;

    public BurnItemRecipeWrapper(BurnItemRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(ItemStack.class, IngredientHelper.getStacksFromIngredient(recipe.getInputs()));
        ingredients.setOutput(ItemStack.class, recipe.getOutputStack());
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        FontRenderer renderer = minecraft.fontRenderer;
        renderer.drawStringWithShadow(
                I18n.format(InWorldCrafting.MODID+".jei.burn_item.description", String.valueOf(recipe.getTicks())),
                1,30,0xFFFFFF);
    }
}
