package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;


public class CampfireRecipe {

    private static int craftCounter = 0;

    public void CampfireRecipeMethods(String group, @NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull ItemStack input, float experience, int cookingTime) {
        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(input);
        org.bukkit.inventory.CampfireRecipe campfireRecipe = new org.bukkit.inventory.CampfireRecipe(key, result, inputChoice, experience, cookingTime * 20);
        campfireRecipe.setGroup(group);
        Bukkit.addRecipe(campfireRecipe);
        craftCounter++;
    }

    public static int getCraftsCount() {
        return craftCounter;
    }

}
