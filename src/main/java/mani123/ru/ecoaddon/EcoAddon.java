package mani123.ru.ecoaddon;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.impl.PluginCommand;
import mani123.ru.ecoaddon.Command.CommandEcoAddon;
import mani123.ru.ecoaddon.Config.CraftsYml;
import mani123.ru.ecoaddon.RecipeMethods.*;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public final class EcoAddon extends EcoPlugin {

    private static EcoAddon instance;

    private static final ArrayList<NamespacedKey> AllCustomCrafts = new ArrayList<>();

    private final CraftsYml craftsYml;

    public EcoAddon() {
        super(2178, 14724, "&7");

        instance = this;
        craftsYml = new CraftsYml(this);

    }

    @Override
    protected List<Listener> loadListeners() {
        return List.of();
    }

    @Override
    protected void handleReload() {
        DefaultMethods.ClearCrafts(AllCustomCrafts);
        FurnaceCraft.FurnaceCraftListener(this);
        BlastingCraft.BlastingCraftListener(this);
        CampfireCraft.CampfireCraftListener(this);
        StoneCutterCraft.StoneCutterCraftListener(this);
        SmithingCraft.SmithingCraftListener(this);
        SmokingCraft.SmokingCraftListener(this);
        AllCustomCrafts.clear();
        AllCustomCrafts.addAll(BlastingCraft.getNamespaces());
        AllCustomCrafts.addAll(CampfireCraft.getNamespaces());
        AllCustomCrafts.addAll(StoneCutterCraft.getNamespaces());
        AllCustomCrafts.addAll(SmokingCraft.getNamespaces());
        AllCustomCrafts.addAll(SmithingCraft.getNamespaces());
        AllCustomCrafts.addAll(FurnaceCraft.getNamespaces());
    }

    protected void handleAfterLoad() {
        FurnaceCraft.FurnaceCraftListener(this);
        BlastingCraft.BlastingCraftListener(this);
        CampfireCraft.CampfireCraftListener(this);
        StoneCutterCraft.StoneCutterCraftListener(this);
        SmokingCraft.SmokingCraftListener(this);
        SmithingCraft.SmithingCraftListener(this);
        AllCustomCrafts.addAll(BlastingCraft.getNamespaces());
        AllCustomCrafts.addAll(CampfireCraft.getNamespaces());
        AllCustomCrafts.addAll(StoneCutterCraft.getNamespaces());
        AllCustomCrafts.addAll(SmokingCraft.getNamespaces());
        AllCustomCrafts.addAll(SmithingCraft.getNamespaces());
        AllCustomCrafts.addAll(FurnaceCraft.getNamespaces());
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

    public ArrayList<NamespacedKey> getAllCustomCrafts() {
        return AllCustomCrafts;
    }

    @Override
    public String getMinimumEcoVersion() {
        return "6.35.1";
    }

}