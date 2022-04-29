package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.config.interfaces.Config;
import com.willfp.eco.core.items.Items;
import com.willfp.eco.util.NamespacedKeyUtils;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BlastingCraft {

    private static final ArrayList<NamespacedKey> BlastingNamespaces = new ArrayList<>();

    private static final ArrayList<String> BlastingIds = new ArrayList<>();

    public static void BlastingCraftListener(@NotNull final EcoAddon plugin) {
        if (!plugin.getConfigYml().getBool("enableBlastingRecipe")) return;
        BlastingIds.clear();
        for (Config CfgSub : plugin.getCraftsYml().getSubsections("BlastingRecipe")) {
            ItemStack input = Items.lookup(CfgSub.getFormattedString("input")).getItem();
            ItemStack result = Items.lookup(CfgSub.getFormattedString("result")).getItem();
            float experience = (float) CfgSub.getDouble("experience");
            int cookingTime = CfgSub.getInt("cookingTime") * 20;
            String id = CfgSub.getFormattedString("id");
            BlastingIds.add(id);
            NamespacedKey namespacedKey = NamespacedKeyUtils.create("ecoaddon", id);
            BlastingNamespaces.add(namespacedKey);
            BlastingRecipe blastingRecipe = new BlastingRecipe(namespacedKey, result, (RecipeChoice) input, experience, cookingTime);
        }
    }

    public static ArrayList<String> getIds() {
        return BlastingIds;
    }

    public static ArrayList<NamespacedKey> getNamespaces() {
        return BlastingNamespaces;
    }

}
