package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.StonecuttingRecipe;
import org.jetbrains.annotations.NotNull;

public class StoneCutter {

    private static int craftCounter = 0;

    public void StoneCutterMethods(String group, @NotNull NamespacedKey key, @NotNull ItemStack input, @NotNull ItemStack result) {
        RecipeChoice resultChange = new RecipeChoice.ExactChoice(result);
        StonecuttingRecipe stonecuttingRecipe = new StonecuttingRecipe(key, input, resultChange);
        stonecuttingRecipe.setGroup(group);
        Bukkit.addRecipe(stonecuttingRecipe);
        craftCounter++;
    }

    public static int getCraftsCount() {
        return craftCounter;
    }

}

