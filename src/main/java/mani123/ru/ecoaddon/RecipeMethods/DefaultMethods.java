package mani123.ru.ecoaddon.RecipeMethods;

import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DefaultMethods {

    public static String getAllCraftsCount() {
        return String.valueOf(Integer.parseInt(FurnaceRecipe.getCraftsCount().toString())
                + Integer.parseInt(StoneCutter.getCraftsCount().toString())
                + Integer.parseInt(CampfireRecipe.getCraftsCount().toString())
                + Integer.parseInt(SmokingRecipe.getCraftsCount().toString())
                + Integer.parseInt(SmithingRecipe.getCraftsCount().toString())
                + Integer.parseInt(BlastingRecipe.getCraftsCount().toString()));
    }

    public static String getAllCraftsNames() {
        return FurnaceRecipe.getCraftsNames().toString()
                + StoneCutter.getCraftsNames()
                + SmokingRecipe.getCraftsNames()
                + CampfireRecipe.getCraftsNames()
                + SmithingRecipe.getCraftsNames()
                + BlastingRecipe.getCraftsNames();
    }

    public static ItemStack getAIR(){
        return new ItemStack(Material.AIR);
    }

    public static String getCraftsNamesList(String name) {
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i < EcoAddon.getPlugin().getCraftsYml().getSubsections(name).size(); i++) {
            out.add(EcoAddon.getPlugin().getCraftsYml().getSubsections(name).get(i).getString("id"));
        }
        return out.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public static String getCraftsNamesListCount(String name) {
        return String.valueOf(EcoAddon.getPlugin().getCraftsYml().getSubsections(name).size());
    }

}
