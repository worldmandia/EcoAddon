package mani123.ru.ecoaddon.RecipeMethods;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DefaultMethods {

    public static void ClearCrafts(ArrayList<NamespacedKey> items) {
        for (NamespacedKey keys : items) {
            Bukkit.removeRecipe(keys);
        }
    }

    public static String getFormattedList(ArrayList<String> list) {
        return list.stream().sorted().map(Object::toString).collect(Collectors.joining(",\n"));
    }

}
