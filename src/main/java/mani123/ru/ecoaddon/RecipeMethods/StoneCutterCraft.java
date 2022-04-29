package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.config.interfaces.Config;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import com.willfp.eco.util.StringUtils;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.StonecuttingRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StoneCutterCraft {

    private static final ArrayList<NamespacedKey> StoneCutterNamespaces = new ArrayList<>();
    private static final ArrayList<String> StoneCutterIds = new ArrayList<>();

    public static void StoneCutterCraftListener(@NotNull final EcoAddon plugin) {
        if (!plugin.getConfigYml().getBool("enableStoneCutter")) return;
        StoneCutterIds.clear();
        for (Config CfgSub : plugin.getCraftsYml().getSubsections("StoneCutter")) {
            String id = CfgSub.getFormattedString("id");
            try {
                RecipeChoice input = new RecipeChoice.ExactChoice(Items.lookup(CfgSub.getFormattedString("input")).getItem());
                ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
                String group = CfgSub.getFormattedString("group");
                NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
                StonecuttingRecipe stonecuttingRecipe = new StonecuttingRecipe(namespacedKey, result, input);
                stonecuttingRecipe.setGroup(group);
                Bukkit.addRecipe(stonecuttingRecipe);
                StoneCutterIds.add(id);
                StoneCutterNamespaces.add(namespacedKey);
            } catch (IllegalArgumentException e) {
                plugin.getServer().getConsoleSender()
                        .sendMessage(plugin.getLangYml().getMessage("broken-craft", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%id%", id)
                                .replace("%reason%", e.getMessage()));
            }
        }
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return StoneCutterNamespaces;
    }

    public static ArrayList<String> getIds() {
        return StoneCutterIds;
    }

}