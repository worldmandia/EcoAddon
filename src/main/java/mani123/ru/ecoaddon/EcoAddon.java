package mani123.ru.ecoaddon;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.impl.PluginCommand;
import com.willfp.eco.core.config.base.ConfigYml;
import mani123.ru.ecoaddon.Command.CommandEcoAddon;
import mani123.ru.ecoaddon.Config.CraftsYml;
import mani123.ru.ecoaddon.RecipeMethods.*;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

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
        return List.of();
    }

    @Override
    protected void handleReload() {
        if (StoneCutter.getCraftsNames() != null) {
            StoneCutter.ClearRecipes();
        }
        if (FurnaceRecipe.getCraftsNames() != null) {
            FurnaceRecipe.ClearRecipes();
        }
        if (CampfireRecipe.getCraftsNames() != null) {
            CampfireRecipe.ClearRecipes();
        }
        if (SmokingRecipe.getCraftsNames() != null) {
            SmokingRecipe.ClearRecipes();
        }
        StoneCutter.StoneCutterListener(this);
        FurnaceRecipe.FurnaceRecipeListener(this);
        CampfireRecipe.CampfireRecipeListener(this);
        SmokingRecipe.SmokingRecipeListener(this);
    }

    protected void handleAfterLoad() {
        StoneCutter.StoneCutterListener(this);
        FurnaceRecipe.FurnaceRecipeListener(this);
        CampfireRecipe.CampfireRecipeListener(this);
        SmokingRecipe.SmokingRecipeListener(this);
    }


    @Override
    protected List<PluginCommand> loadPluginCommands() {
        return List.of(new CommandEcoAddon(this));
    }

    public static EcoAddon getPlugin() {
        return instance;
    }

    public CraftsYml getCraftsYml() {
        return this.craftsYml;
    }


    @Override
    public String getMinimumEcoVersion() {
        return "6.31.1";
    }

}