package mani123.ru.ecoaddon.Command;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.impl.Subcommand;
import com.willfp.eco.util.NumberUtils;
import com.willfp.eco.util.StringUtils;
import mani123.ru.ecoaddon.RecipeMethods.FurnaceRecipe;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommandList extends Subcommand {

    protected CommandList(@NotNull EcoPlugin plugin) {
        super(plugin, "list", "ecoaddon.command.list", false);
    }

    @Override
    public void onExecute(@NotNull final CommandSender sender,
                          @NotNull final List<String> args) {
        sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                .replace("%crafts%", FurnaceRecipe.getCraftsNames().toString())
                .replace("%count%", FurnaceRecipe.getCraftsCount()));
    }

}
