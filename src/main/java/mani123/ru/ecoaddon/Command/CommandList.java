package mani123.ru.ecoaddon.Command;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.impl.Subcommand;
import com.willfp.eco.util.StringUtils;
import mani123.ru.ecoaddon.RecipeMethods.DefaultMethods;
import mani123.ru.ecoaddon.RecipeMethods.FurnaceRecipe;
import mani123.ru.ecoaddon.RecipeMethods.StoneCutter;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CommandList extends Subcommand {

    List<String> completions = new ArrayList<>();

    protected CommandList(@NotNull EcoPlugin plugin) {
        super(plugin, "list", "ecoaddon.command.list", false);
        completions.add("furnace");
        completions.add("stonecutter");
        completions.add("campfire");
    }

    @Override
    public void onExecute(@NotNull final CommandSender sender,
                          @NotNull final List<String> args) {
        switch (args.get(0).toLowerCase(Locale.ROOT)) {
            //case("campfire") -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
            //        .replace("%crafts%", FurnaceRecipe.getCraftsNames().toString())
            //        .replace("%count%", FurnaceRecipe.getCraftsCount()));
            case ("stonecutter") -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                    .replace("%crafts%", StoneCutter.getCraftsNames().toString())
                    .replace("%count%", StoneCutter.getCraftsCount()));
            case ("furnace") -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                    .replace("%crafts%", FurnaceRecipe.getCraftsNames().toString())
                    .replace("%count%", FurnaceRecipe.getCraftsCount()));
            default -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                    .replace("%crafts%", DefaultMethods.getAllCraftsNames())
                    .replace("%count%", DefaultMethods.getAllCraftsCount()));
        }
    }

    @Override
    public List<String> tabComplete(@NotNull final CommandSender sender,
                                    @NotNull final List<String> args) {

        return completions;
    }
}
