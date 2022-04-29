package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.config.interfaces.Config;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import com.willfp.eco.util.StringUtils;
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

    public static void SmithingCraftListener(@NotNull final EcoAddon plugin) {
        if (!plugin.getConfigYml().getBool("enableSmithingRecipe")) return;
        SmithingIds.clear();
        for (Config CfgSub : plugin.getCraftsYml().getSubsections("SmithingRecipe")) {
            String id = CfgSub.getFormattedString("id");
            try {
                ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
                RecipeChoice base = new RecipeChoice.ExactChoice(Items.lookup(CfgSub.getFormattedString("input")).getItem());
                RecipeChoice addition = new RecipeChoice.ExactChoice(Items.lookup(CfgSub.getFormattedString("input")).getItem());
                NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
                SmithingRecipe smithingRecipe = new SmithingRecipe(namespacedKey, result, base, addition);
                Bukkit.addRecipe(smithingRecipe);
                SmithingIds.add(id);
                SmithingNamespaces.add(namespacedKey);
            } catch (IllegalArgumentException e) {
                plugin.getServer().getConsoleSender()
                        .sendMessage(plugin.getLangYml().getMessage("broken-craft", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%id%", id)
                                .replace("%reason%", e.getMessage()));
            }
        }
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return SmithingNamespaces;
    }

    public static ArrayList<String> getIds() {
        return SmithingIds;
    }

}

