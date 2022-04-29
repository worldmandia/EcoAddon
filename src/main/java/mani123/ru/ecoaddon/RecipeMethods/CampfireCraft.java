package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.config.interfaces.Config;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class CampfireCraft {

    private static final ArrayList<NamespacedKey> CampfireNamespaces = new ArrayList<>();

    private static final ArrayList<String> CampfireIds = new ArrayList<>();

    public static void CampfireCraftListener(@NotNull final EcoAddon plugin) {
        if (!plugin.getConfigYml().getBool("enableCampfireRecipe")) return;
        CampfireIds.clear();
        for (Config CfgSub : plugin.getCraftsYml().getSubsections("CampfireRecipe")) {
            ItemStack input = Items.lookup(CfgSub.getFormattedString("input")).getItem();
            ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
            float experience = (float) CfgSub.getDouble("experience");
            int cookingTime = CfgSub.getInt("cookingTime") * 20;
            String id = CfgSub.getFormattedString("id");
            CampfireIds.add(id);
            NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
            CampfireNamespaces.add(namespacedKey);
            CampfireRecipe campfireRecipe = new CampfireRecipe(namespacedKey, result, (RecipeChoice) input, experience, cookingTime);
            Bukkit.addRecipe(campfireRecipe);
        }
    }

    public static ArrayList<String> getIds() {
        return CampfireIds;
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return CampfireNamespaces;
    }

}
