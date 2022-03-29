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


public class CampfireRecipe {

    private static ArrayList<NamespacedKey> CampfireNamespace = new ArrayList<>();

    public static void CampfireRecipeListener(@NotNull final EcoAddon plugin) {
        for (int i = 0; i < plugin.getCraftsYml().getSubsections("CampfireRecipe").size(); i++) {
            if (!Items.lookup(plugin.getCraftsYml().getSubsections("CampfireRecipe").get(i).getFormattedString("input")).matches(DefaultMethods.getAIR())
                    && !Items.lookup(plugin.getCraftsYml().getSubsections("CampfireRecipe").get(i).getFormattedString("result")).matches(DefaultMethods.getAIR())) {
                ItemStack input = Items.lookup(plugin.getCraftsYml().getSubsections("CampfireRecipe").get(i).getFormattedString("input")).getItem();
                ItemStack result = Items.lookup(plugin.getCraftsYml().getSubsections("CampfireRecipe").get(i).getFormattedString("result")).getItem();
                double experience = plugin.getCraftsYml().getSubsections("CampfireRecipe").get(i).getDouble("experience");
                int cookingTime = plugin.getCraftsYml().getSubsections("CampfireRecipe").get(i).getInt("cookingTime");
                NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", plugin.getCraftsYml().getSubsections("CampfireRecipe").get(i).getString("id").toLowerCase().trim());
                CampfireRecipeMethod(namespacedKey, result, input, (float) experience, cookingTime);
            }
        }
    }

    public static void CampfireRecipeMethod(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull ItemStack input, float experience, int cookingTime) {
        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(input);
        Bukkit.addRecipe(new org.bukkit.inventory.CampfireRecipe(key, result, inputChoice, experience, cookingTime * 20));
        CampfireNamespace.add(key);
    }

    public static CharSequence getCraftsCount() {
        return String.valueOf(CampfireNamespace.size());
    }

    public static ArrayList<NamespacedKey> getCraftsNames() {
        return CampfireNamespace;
    }

    public static void ClearRecipes() {
        for (NamespacedKey namespacedKey : CampfireNamespace) {
            Bukkit.removeRecipe(namespacedKey);
        }
        CampfireNamespace.clear();
    }

}
