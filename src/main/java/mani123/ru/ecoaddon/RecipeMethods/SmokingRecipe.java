package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SmokingRecipe {

    private static ArrayList<NamespacedKey> SmokingNamespace = new ArrayList<>();

    public static void SmokingRecipeListener(@NotNull final EcoAddon plugin) {
        if (plugin.getConfigYml().getBool("enableSmokingRecipe")) {
            for (int i = 0; i < plugin.getCraftsYml().getSubsections("SmokingRecipe").size(); i++) {
                if (!Items.lookup(plugin.getCraftsYml().getSubsections("SmokingRecipe").get(i).getFormattedString("input")).matches(DefaultMethods.getAIR())
                        && !Items.lookup(plugin.getCraftsYml().getSubsections("SmokingRecipe").get(i).getFormattedString("result")).matches(DefaultMethods.getAIR())) {
                    ItemStack input = Items.lookup(plugin.getCraftsYml().getSubsections("SmokingRecipe").get(i).getFormattedString("input")).getItem();
                    ItemStack result = Items.lookup(plugin.getCraftsYml().getSubsections("SmokingRecipe").get(i).getFormattedString("result")).getItem();
                    double experience = plugin.getCraftsYml().getSubsections("SmokingRecipe").get(i).getDouble("experience");
                    int cookingTime = plugin.getCraftsYml().getSubsections("SmokingRecipe").get(i).getInt("cookingTime");
                    NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", plugin.getCraftsYml().getSubsections("SmokingRecipe").get(i).getString("id").toLowerCase().trim());
                    SmokingRecipeMethod(namespacedKey, result, input, (float) experience, cookingTime);
                }
            }
        }
    }

    public static void SmokingRecipeMethod(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull ItemStack input, float experience, int cookingTime) {
        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(input);
        Bukkit.addRecipe(new org.bukkit.inventory.SmokingRecipe(key, result, inputChoice, experience, cookingTime * 20));
        SmokingNamespace.add(key);
    }

    public static CharSequence getCraftsCount() {
        return String.valueOf(SmokingNamespace.size());
    }

    public static ArrayList<NamespacedKey> getCraftsNames() {
        return SmokingNamespace;
    }

    public static void ClearRecipes() {
        for (NamespacedKey namespacedKey : SmokingNamespace) {
            Bukkit.removeRecipe(namespacedKey);
        }
        SmokingNamespace.clear();
    }

}
