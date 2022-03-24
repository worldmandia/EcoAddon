package mani123.ru.ecoaddon;

import com.willfp.ecoitems.items.EcoItems;
import mani123.ru.ecoaddon.RecipeMethods.CampfireRecipeMethods;
import mani123.ru.ecoaddon.RecipeMethods.DefaultMethods;
import mani123.ru.ecoaddon.RecipeMethods.FurnaceRecipeMethods;
import mani123.ru.ecoaddon.RecipeMethods.StoneCutterMethods;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class EcoAddon extends JavaPlugin {

    String inputID = "enchanted_cobblestone";
    String outputID = "enchanted_ender_eye";


    @Override
    public void onEnable() {

        // Test StoneCutterMethods
        StoneCutterMethods scMethods = new StoneCutterMethods();
        scMethods.addRecipeStoneCutter("group2", DefaultMethods.getRecipeID("1"),
                Objects.requireNonNull(EcoItems.getByID(inputID)).getItemStack(),
                Objects.requireNonNull(EcoItems.getByID(outputID)).getItemStack());

        // Test FurnaceRecipeMethods
        FurnaceRecipeMethods frMethods = new FurnaceRecipeMethods();
        frMethods.addFurnaceRecipe(DefaultMethods.getRecipeID("2"),
                Objects.requireNonNull(EcoItems.getByID(outputID)).getItemStack(),
                Objects.requireNonNull(EcoItems.getByID(inputID)).getItemStack(), 1, 20);

        // Test CampfireRecipeMethods
        CampfireRecipeMethods crMethods = new CampfireRecipeMethods();
        crMethods.addCampfireRecipe("group1", DefaultMethods.getRecipeID("3"),
                Objects.requireNonNull(EcoItems.getByID(outputID)).getItemStack(),
                Objects.requireNonNull(EcoItems.getByID(inputID)).getItemStack(), 1, 20);

        // Messages on Enable plugin
        Bukkit.getConsoleSender().sendMessage("Hello, you have: " + EcoItems.values() + " custom items in Eco plugin"
                + "\nVersion of plugin: soon"
                + "\nPlugin work on version: " + getServer().getBukkitVersion()
                + "\nTotal crafts by this plugin: " + DefaultMethods.getAllCraftsCount());

        // Other

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Review plugin on Polymart");
    }
}

