package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.NamespacedKey;

import java.util.ArrayList;

public class DefaultMethods {

    public static CharSequence getAllCraftsCount() {
        return String.valueOf(CampfireRecipe.getCraftsCount()) + Integer.parseInt(FurnaceRecipe.getCraftsCount() + StoneCutter.getCraftsCount().toString());
    }

    public static String getAllCraftsNames() {
        return FurnaceRecipe.getCraftsNames().toString() + StoneCutter.getCraftsNames();
    }

}
