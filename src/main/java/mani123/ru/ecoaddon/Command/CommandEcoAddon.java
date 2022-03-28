package mani123.ru.ecoaddon.Command;

import com.willfp.eco.core.command.impl.PluginCommand;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommandEcoAddon extends PluginCommand {

    public CommandEcoAddon(@NotNull final EcoAddon plugin) {
        super(plugin, "ecoaddon", "ecoaddon.command.ecoaddon", false);

        this.addSubcommand(new CommandReload(plugin));
        this.addSubcommand(new CommandList(plugin));
    }

    @Override
    public void onExecute(@NotNull final CommandSender sender,
                          @NotNull final List<String> args) {
        sender.sendMessage(this.getPlugin().getLangYml().getMessage("invalid-command"));
    }

}