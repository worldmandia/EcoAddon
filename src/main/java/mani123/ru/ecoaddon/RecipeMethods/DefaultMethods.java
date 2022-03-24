package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.NamespacedKey;

public class DefaultMethods {

    public static int getAllCraftsCount() {
        return CampfireRecipe.getCraftsCount() + FurnaceRecipe.getCraftsCount() + StoneCutter.getCraftsCount();
    }

    public static NamespacedKey getRecipeID(String idCrafts) {
        return NamespacedKey.minecraft(idCrafts + "_eap_craft");
    }

}
