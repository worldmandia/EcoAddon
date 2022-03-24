package mani123.ru.ecoaddon;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.impl.PluginCommand;
import com.willfp.ecoitems.commands.CommandReload;
import mani123.ru.ecoaddon.Command.CommandEcoAddon;
import mani123.ru.ecoaddon.Config.CraftsYml;
import org.bukkit.event.Listener;

import java.util.Arrays;
import java.util.List;

public final class EcoAddon extends EcoPlugin {

    private static EcoAddon instance;

    private final CraftsYml craftsYml;

    public EcoAddon() {
        super(-1, 14724, "&7");
        instance = this;

        craftsYml = new CraftsYml(this);

    }

    @Override
    protected List<Listener> loadListeners() {
        return null;
    }

    @Override
    protected List<PluginCommand> loadPluginCommands() {
        return Arrays.asList(
                new CommandEcoAddon(this)
        );
    }

    @Override
    public String getMinimumEcoVersion() {
        return "6.27.2";
    }

}

//String inputID = "pink_crystal";
//String outputID = "pink_dust";

//@Override
//public void onEnable() {
//// Test StoneCutterMethods
//StoneCutterMethods scMethods = new StoneCutterMethods();
//scMethods.addRecipeStoneCutter("group2", DefaultMethods.getRecipeID("1"),
//Objects.requireNonNull(EcoItems.getByID(inputID)).getItemStack(),
//Objects.requireNonNull(EcoItems.getByID(outputID)).getItemStack());

//// Test FurnaceRecipeMethods
//FurnaceRecipeMethods frMethods = new FurnaceRecipeMethods();
//frMethods.addFurnaceRecipe(DefaultMethods.getRecipeID("2"),
//Objects.requireNonNull(EcoItems.getByID(outputID)).getItemStack(),
//Objects.requireNonNull(EcoItems.getByID(inputID)).getItemStack(), 1, 20);

//// Test CampfireRecipeMethods
//CampfireRecipeMethods crMethods = new CampfireRecipeMethods();
//crMethods.addCampfireRecipe("group1", DefaultMethods.getRecipeID("3"),
//Objects.requireNonNull(EcoItems.getByID(outputID)).getItemStack(),
//Objects.requireNonNull(EcoItems.getByID(inputID)).getItemStack(), 1, 20);

//// Messages on Enable plugin
//Bukkit.getConsoleSender().sendMessage("Hello, you have: " + EcoItems.values() + " custom items in Eco plugin"
//+ "\nVersion of plugin: soon"
//+ "\nPlugin work on version: " + getServer().getBukkitVersion()
//+ "\nTotal crafts by this plugin: " + DefaultMethods.getAllCraftsCount());

//// Other

//}

//@Override
//public void onDisable() {
//Bukkit.getConsoleSender().sendMessage("Review plugin on Polymart");
//}

