package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.config.interfaces.Config;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
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
            ItemStack input = Items.lookup(CfgSub.getFormattedString("input")).getItem();
            ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
            float experience = (float) CfgSub.getDouble("experience");
            int cookingTime = CfgSub.getInt("cookingTime") * 20;
            String id = CfgSub.getFormattedString("id");
            FurnaceIds.add(id);
            NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
            FurnaceNamespaces.add(namespacedKey);
            FurnaceRecipe furnaceRecipe = new FurnaceRecipe(namespacedKey, result, (RecipeChoice) input, experience, cookingTime);
            Bukkit.addRecipe(furnaceRecipe);
        }
    }

    public static ArrayList<String> getIds() {
        return FurnaceIds;
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return FurnaceNamespaces;
    }

}
