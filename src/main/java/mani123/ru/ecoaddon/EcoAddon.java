package mani123.ru.ecoaddon;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.impl.PluginCommand;
import mani123.ru.ecoaddon.Command.CommandEcoAddon;
import mani123.ru.ecoaddon.Config.CraftsYml;
import mani123.ru.ecoaddon.RecipeMethods.FurnaceRecipe;
import org.bukkit.event.Listener;

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
        return List.of(
                new FurnaceRecipe(this)
        );
    }



    @Override
    protected List<PluginCommand> loadPluginCommands() {
        return List.of(
                new CommandEcoAddon(this)
        );
    }

    public CraftsYml getCraftsYml() {
        return this.craftsYml;
    }


    @Override
    public String getMinimumEcoVersion() {
        return "6.31.0";
    }

}