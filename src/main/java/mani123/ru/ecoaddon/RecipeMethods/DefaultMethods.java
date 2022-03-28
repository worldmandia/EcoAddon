package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.NamespacedKey;

public class DefaultMethods {

    public static int getAllCraftsCount() {
        return CampfireRecipe.getCraftsCount() + Integer.parseInt(FurnaceRecipe.getCraftsCount().toString()) + StoneCutter.getCraftsCount();
    }

    public static NamespacedKey getRecipeID(String idCrafts) {
        return NamespacedKey.minecraft(idCrafts + "_eap_craft");
    }

}
