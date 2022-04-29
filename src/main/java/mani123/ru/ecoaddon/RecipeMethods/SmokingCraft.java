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
import org.bukkit.inventory.SmokingRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SmokingCraft {

    private static final ArrayList<NamespacedKey> SmokingNamespaces = new ArrayList<>();

    private static final ArrayList<String> SmokingIds = new ArrayList<>();

    public static void SmokingCraftListener(@NotNull final EcoAddon plugin) {
        if (!plugin.getConfigYml().getBool("enableSmokingRecipe")) return;
        SmokingIds.clear();
        for (Config CfgSub : plugin.getCraftsYml().getSubsections("SmokingRecipe")) {
            String id = CfgSub.getFormattedString("id");
            try {
                RecipeChoice input = new RecipeChoice.ExactChoice(Items.lookup(CfgSub.getFormattedString("input")).getItem());
                ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
                float experience = (float) CfgSub.getDouble("experience");
                int cookingTime = CfgSub.getInt("cookingTime") * 20;
                SmokingIds.add(id);
                NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
                SmokingNamespaces.add(namespacedKey);
                SmokingRecipe smokingRecipe = new SmokingRecipe(namespacedKey, result, input, experience, cookingTime);
                Bukkit.addRecipe(smokingRecipe);
            } catch (IllegalArgumentException e) {
                plugin.getServer().getConsoleSender()
                        .sendMessage(plugin.getLangYml().getMessage("broken-craft", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%id%", id)
                                .replace("%reason%", e.getMessage()));
            }
        }
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return SmokingNamespaces;
    }

    public static ArrayList<String> getIds() {
        return SmokingIds;
    }

}
