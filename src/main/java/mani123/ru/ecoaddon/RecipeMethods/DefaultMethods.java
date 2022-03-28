package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.NamespacedKey;

import java.util.ArrayList;

public class DefaultMethods {

    public static CharSequence getAllCraftsCount() {
        return String.valueOf(CampfireRecipe.getCraftsCount() + StoneCutter.getCraftsCount()) + Integer.parseInt(FurnaceRecipe.getCraftsCount().toString());
    }

    public static ArrayList<NamespacedKey> getAllCraftsNames() {
        return FurnaceRecipe.getCraftsNames();
    }

}
