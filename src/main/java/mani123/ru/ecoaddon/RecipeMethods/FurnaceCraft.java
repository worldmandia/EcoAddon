package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.config.interfaces.Config;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import com.willfp.eco.util.StringUtils;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FurnaceCraft {

    private static final ArrayList<NamespacedKey> FurnaceNamespaces = new ArrayList<>();
    private static final ArrayList<String> FurnaceIds = new ArrayList<>();

    public static void FurnaceCraftListener(@NotNull final EcoAddon plugin) {
        if (!plugin.getConfigYml().getBool("enableFurnaceRecipe")) return;
        FurnaceIds.clear();
        for (Config CfgSub : plugin.getConfigYml().getSubsections("FurnaceRecipe")) {
            String id = CfgSub.getFormattedString("id");
            try {
                RecipeChoice input = new RecipeChoice.ExactChoice(Items.lookup(CfgSub.getFormattedString("input")).getItem());
                ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
                float experience = (float) CfgSub.getDouble("experience");
                int cookingTime = CfgSub.getInt("cookingTime") * 20;
                NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
                FurnaceRecipe furnaceRecipe = new FurnaceRecipe(namespacedKey, result, input, experience, cookingTime);
                Bukkit.addRecipe(furnaceRecipe);
                FurnaceNamespaces.add(namespacedKey);
                FurnaceIds.add(id);
            } catch (IllegalArgumentException e) {
                plugin.getServer().getConsoleSender()
                        .sendMessage(plugin.getLangYml().getMessage("broken-craft", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%id%", id)
                                .replace("%reason%", e.getMessage()));
            }
        }
    }

    public static ArrayList<String> getIds() {
        return FurnaceIds;
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return FurnaceNamespaces;
    }

}
