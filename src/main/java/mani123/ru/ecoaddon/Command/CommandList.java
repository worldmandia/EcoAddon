package mani123.ru.ecoaddon.Command;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.impl.Subcommand;
import com.willfp.eco.util.StringUtils;
import mani123.ru.ecoaddon.RecipeMethods.DefaultMethods;
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
        completions.add("smoking");
        completions.add("all");
    }

    @Override
    public void onExecute(@NotNull final CommandSender sender, @NotNull final List<String> args) {
        if (args.size() >= 1) {
            switch (args.get(0).toLowerCase(Locale.ROOT)) {
                case ("smoking") -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS).replace("%crafts%", DefaultMethods.getCraftsNamesList("SmokingRecipe")).replace("%count%", DefaultMethods.getCraftsNamesListCount("SmokingRecipe")));
                case ("campfire") -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS).replace("%crafts%", DefaultMethods.getCraftsNamesList("CampfireRecipe")).replace("%count%", DefaultMethods.getCraftsNamesListCount("CampfireRecipe")));
                case ("stonecutter") -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS).replace("%crafts%", DefaultMethods.getCraftsNamesList("StoneCutter")).replace("%count%", DefaultMethods.getCraftsNamesListCount("StoneCutter")));
                case ("furnace") -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS).replace("%crafts%", DefaultMethods.getCraftsNamesList("FurnaceRecipe")).replace("%count%", DefaultMethods.getCraftsNamesListCount("FurnaceRecipe")));
                case ("all") -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS).replace("%crafts%", DefaultMethods.getAllCraftsNames()).replace("%count%", DefaultMethods.getAllCraftsCount()));
                default -> sender.sendMessage(this.getPlugin().getLangYml().getMessage("invalid-command"));
            }
        } else {
            sender.sendMessage(this.getPlugin().getLangYml().getMessage("invalid-command"));
        }

    }

    @Override
    public List<String> tabComplete(@NotNull final CommandSender sender, @NotNull final List<String> args) {

        return completions;
    }
}
