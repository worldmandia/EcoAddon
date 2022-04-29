package mani123.ru.ecoaddon.RecipeMethods;

import com.willfp.eco.libs.jetbrains.annotations.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DefaultMethods {

    public static void ClearCrafts(@NotNull ArrayList<NamespacedKey> items) {
        for (NamespacedKey keys : items) {
            Bukkit.removeRecipe(keys);
        }
    }

    public static String getFormattedList(@NotNull ArrayList<String> list) {
        return list.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

}
