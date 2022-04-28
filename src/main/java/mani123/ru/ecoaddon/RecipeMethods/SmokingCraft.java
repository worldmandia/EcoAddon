package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.config.interfaces.Config;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmokingRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SmokingCraft {

    private static final ArrayList<NamespacedKey> SmokingNamespaces = new ArrayList<>();

    private static final ArrayList<String> SmokingIds = new ArrayList<>();

    public static void SmokingRecipeListener(@NotNull final EcoAddon plugin) {
        if (!plugin.getConfigYml().getBool("enableSmokingRecipe")) return;
        SmokingIds.clear();
        for (Config CfgSub : plugin.getCraftsYml().getSubsections("SmokingRecipe")) {
            ItemStack input = Items.lookup(CfgSub.getFormattedString("input")).getItem();
            ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
            float experience = (float) CfgSub.getDouble("experience");
            int cookingTime = CfgSub.getInt("cookingTime") * 20;
            String id = CfgSub.getFormattedString("id");
            NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
            SmokingNamespaces.add(namespacedKey);
            SmokingIds.add(id);
            SmokingRecipe smokingRecipe = new SmokingRecipe(namespacedKey, result, (RecipeChoice) input, experience, cookingTime);
            Bukkit.addRecipe(smokingRecipe);
        }
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return SmokingNamespaces;
    }

    public static ArrayList<String> getIds() {
        return SmokingIds;
    }

}
