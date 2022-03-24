package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;


public class CampfireRecipeMethods {

    private static int craftCounter = 0;

    public void addCampfireRecipe(String group, @NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull ItemStack input, float experience, int cookingTime) {
        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(input);
        CampfireRecipe campfireRecipe = new CampfireRecipe(key, result, inputChoice, experience, cookingTime * 20);
        campfireRecipe.setGroup(group);
        Bukkit.addRecipe(campfireRecipe);
        craftCounter++;
    }

    public static int getCraftsCount() {
        return craftCounter;
    }

}
