package mani123.ru.ecoaddon.Command;

import com.willfp.eco.core.command.impl.Subcommand;
import com.willfp.eco.util.NumberUtils;
import com.willfp.eco.util.StringUtils;
import mani123.ru.ecoaddon.EcoAddon;
import mani123.ru.ecoaddon.RecipeMethods.FurnaceRecipe;
import mani123.ru.ecoaddon.RecipeMethods.StoneCutter;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommandReload extends Subcommand {


    protected CommandReload(@NotNull final EcoAddon plugin) {
        super(plugin, "reload", "ecoaddon.command.reload", false);

    }


    @Override
    public void onExecute(@NotNull final CommandSender sender,
                          @NotNull final List<String> args) {
        sender.sendMessage(this.getPlugin().getLangYml().getMessage("reloaded", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                .replace("%time%", NumberUtils.format(this.getPlugin().reloadWithTime())));
    }

}