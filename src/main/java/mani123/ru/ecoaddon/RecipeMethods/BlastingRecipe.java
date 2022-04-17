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

public class BlastingRecipe {

    private static ArrayList<NamespacedKey> BlastingNamespace = new ArrayList<>();

    public static void BlastingRecipeListener(@NotNull final EcoAddon plugin) {
        if (plugin.getConfigYml().getBool("enableBlastingRecipe")) {
            for (int i = 0; i < plugin.getCraftsYml().getSubsections("BlastingRecipe").size(); i++) {
                if (!Items.lookup(plugin.getCraftsYml().getSubsections("BlastingRecipe").get(i).getFormattedString("input")).matches(DefaultMethods.getAIR()) && !Items.lookup(plugin.getCraftsYml().getSubsections("BlastingRecipe").get(i).getFormattedString("result")).matches(DefaultMethods.getAIR())) {
                    ItemStack input = Items.lookup(plugin.getCraftsYml().getSubsections("BlastingRecipe").get(i).getFormattedString("input")).getItem();
                    ItemStack result = Items.lookup(plugin.getCraftsYml().getSubsections("BlastingRecipe").get(i).getFormattedString("result")).getItem();
                    double experience = plugin.getCraftsYml().getSubsections("BlastingRecipe").get(i).getDouble("experience");
                    int cookingTime = plugin.getCraftsYml().getSubsections("BlastingRecipe").get(i).getInt("cookingTime");
                    NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", plugin.getCraftsYml().getSubsections("BlastingRecipe").get(i).getString("id").toLowerCase().trim());
                    BlastingRecipeMethod(namespacedKey, result, input, (float) experience, cookingTime);
                }
            }
        }
    }

    public static void BlastingRecipeMethod(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull ItemStack input, float experience, int cookingTime) {
        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(input);
        Bukkit.addRecipe(new org.bukkit.inventory.BlastingRecipe(key, result, inputChoice, experience, cookingTime * 20));
        BlastingNamespace.add(key);
    }

    public static CharSequence getCraftsCount() {
        return String.valueOf(BlastingNamespace.size());
    }

    public static ArrayList<NamespacedKey> getCraftsNames() {
        return BlastingNamespace;
    }

    public static void ClearRecipes() {
        for (NamespacedKey namespacedKey : BlastingNamespace) {
            Bukkit.removeRecipe(namespacedKey);
        }
        BlastingNamespace.clear();
    }

}
