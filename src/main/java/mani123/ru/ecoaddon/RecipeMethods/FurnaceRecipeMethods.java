package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;

public class FurnaceRecipeMethods {

    private static int craftCounter = 0;

    public void addFurnaceRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull ItemStack input, float experience, int cookingTime) {
        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(input);
        Bukkit.addRecipe(new FurnaceRecipe(key, result, inputChoice, experience, cookingTime * 20));
        craftCounter++;
    }

    public static int getCraftsCount() {
        return craftCounter;
    }

}
