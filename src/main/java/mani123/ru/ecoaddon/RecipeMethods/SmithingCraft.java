package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.config.interfaces.Config;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SmithingCraft {

    private static final ArrayList<NamespacedKey> SmithingNamespaces = new ArrayList<>();

    private static final ArrayList<String> SmithingIds = new ArrayList<>();

    public static void SmithingRecipeListener(@NotNull final EcoAddon plugin) {
        if (!plugin.getConfigYml().getBool("enableSmithingRecipe")) return;
        SmithingIds.clear();
        for (Config CfgSub : plugin.getCraftsYml().getSubsections("SmithingRecipe")) {
            ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
            ItemStack base = Items.lookup(CfgSub.getFormattedString("base_item")).getItem();
            ItemStack addition = Items.lookup(CfgSub.getFormattedString("add_item")).getItem();
            String id = CfgSub.getFormattedString("id");
            SmithingIds.add(id);
            NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
            SmithingNamespaces.add(namespacedKey);
            SmithingRecipe smithingRecipe = new SmithingRecipe(namespacedKey, result, (RecipeChoice) base, (RecipeChoice) addition);
            Bukkit.addRecipe(smithingRecipe);
        }
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return SmithingNamespaces;
    }

    public static ArrayList<String> getIds() {
        return SmithingIds;
    }

}

