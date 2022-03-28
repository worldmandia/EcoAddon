package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.PluginDependent;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FurnaceRecipe extends PluginDependent<EcoPlugin> implements Listener {

    private static ArrayList<NamespacedKey> FurnaceNamespace = new ArrayList<>();

    public FurnaceRecipe(@NotNull final EcoAddon plugin) {
        super(plugin);
        FurnaceRecipeListener(plugin);
    }

    public static void FurnaceRecipeListener(@NotNull final EcoAddon plugin) {
        if (FurnaceNamespace != null) {
            ClearRecipes();
        }
        for (int i = 0; i < plugin.getCraftsYml().getSubsections("FurnaceRecipe").size(); i++) {
            ItemStack input = Items.lookup(plugin.getCraftsYml().getSubsections("FurnaceRecipe").get(i).getFormattedString("input")).getItem();
            ItemStack result = Items.lookup(plugin.getCraftsYml().getSubsections("FurnaceRecipe").get(i).getFormattedString("result")).getItem();
            double experience = plugin.getCraftsYml().getSubsections("FurnaceRecipe").get(i).getDouble("experience");
            int cookingTime = plugin.getCraftsYml().getSubsections("FurnaceRecipe").get(i).getInt("cookingTime");
            NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon",plugin.getCraftsYml().getSubsections("FurnaceRecipe").get(i).getString("id").toLowerCase().trim());
            FurnaceRecipeMethod(namespacedKey, result, input, (float) experience, cookingTime);
        }
    }

    public static void FurnaceRecipeMethod(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull ItemStack input, float experience, int cookingTime) {
        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(input);
        Bukkit.addRecipe(new org.bukkit.inventory.FurnaceRecipe(key, result, inputChoice, experience, cookingTime * 20));
        FurnaceNamespace.add(key);
    }

    public static CharSequence getCraftsCount() {
        return String.valueOf(FurnaceNamespace.size());
    }

    public static ArrayList<NamespacedKey> getCraftsNames() {
        return FurnaceNamespace;
    }

    public static void ClearRecipes() {
        for (NamespacedKey namespacedKey : FurnaceNamespace) {
            Bukkit.removeRecipe(namespacedKey);
        }
        FurnaceNamespace.clear();
    }

}
