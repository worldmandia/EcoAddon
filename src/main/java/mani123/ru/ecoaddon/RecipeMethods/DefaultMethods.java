package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.core.EcoPlugin;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class DefaultMethods {

    public static int getAllCraftsCount() {
        return CampfireRecipeMethods.getCraftsCount() + FurnaceRecipeMethods.getCraftsCount() + StoneCutterMethods.getCraftsCount();
    }

    public static NamespacedKey getRecipeID(String idCrafts) {
        return NamespacedKey.minecraft(idCrafts + "_eap_craft");
    }

}
