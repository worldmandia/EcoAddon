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

public class SmithingRecipe {

    private static ArrayList<NamespacedKey> SmithingNamespace = new ArrayList<>();

    public static void SmithingRecipeListener(@NotNull final EcoAddon plugin) {
        if (plugin.getConfigYml().getBool("enableSmithingRecipe")) {
            for (int i = 0; i < plugin.getCraftsYml().getSubsections("SmithingRecipe").size(); i++) {
                if (!Items.lookup(plugin.getCraftsYml().getSubsections("SmithingRecipe").get(i).getFormattedString("base_item")).matches(DefaultMethods.getAIR())
                        && !Items.lookup(plugin.getCraftsYml().getSubsections("SmithingRecipe").get(i).getFormattedString("add_item")).matches(DefaultMethods.getAIR())
                        && !Items.lookup(plugin.getCraftsYml().getSubsections("SmithingRecipe").get(i).getFormattedString("result")).matches(DefaultMethods.getAIR())) {
                    ItemStack base = Items.lookup(plugin.getCraftsYml().getSubsections("SmithingRecipe").get(i).getFormattedString("base_item")).getItem();
                    ItemStack addition = Items.lookup(plugin.getCraftsYml().getSubsections("SmithingRecipe").get(i).getFormattedString("add_item")).getItem();
                    ItemStack result = Items.lookup(plugin.getCraftsYml().getSubsections("SmithingRecipe").get(i).getFormattedString("result")).getItem();
                    NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", plugin.getCraftsYml().getSubsections("SmithingRecipe").get(i).getString("id").toLowerCase().trim());
                    SmithingRecipeMethod(namespacedKey, result, base, addition);
                }
            }
        }
    }

    public static void SmithingRecipeMethod(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull ItemStack base, @NotNull ItemStack addition) {
        RecipeChoice baseChoice = new RecipeChoice.ExactChoice(base);
        RecipeChoice additionChoice = new RecipeChoice.ExactChoice(addition);
        Bukkit.addRecipe(new org.bukkit.inventory.SmithingRecipe(key, result, baseChoice, additionChoice));
        SmithingNamespace.add(key);
    }

    public static CharSequence getCraftsCount() {
        return String.valueOf(SmithingNamespace.size());
    }

    public static ArrayList<NamespacedKey> getCraftsNames() {
        return SmithingNamespace;
    }

    public static void ClearRecipes() {
        for (NamespacedKey namespacedKey : SmithingNamespace) {
            Bukkit.removeRecipe(namespacedKey);
        }
        SmithingNamespace.clear();
    }

}

