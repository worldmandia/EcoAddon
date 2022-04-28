package mani123.ru.ecoaddon.Command;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.impl.Subcommand;
import com.willfp.eco.core.config.base.LangYml;
import com.willfp.eco.util.StringUtils;
import mani123.ru.ecoaddon.RecipeMethods.DefaultMethods;
import mani123.ru.ecoaddon.RecipeMethods.SmokingCraft;
import mani123.ru.ecoaddon.RecipeMethods.StoneCutter;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CommandList extends Subcommand {

    private final LangYml lang = this.getPlugin().getLangYml();

    protected CommandList(@NotNull EcoPlugin plugin) {
        super(plugin, "list", "ecoaddon.command.list", false);
    }

    @Override
    public void onExecute(@NotNull final CommandSender sender, @NotNull final List<String> args) {
        if (args.size() >= 1) {
            switch (args.get(0).toLowerCase(Locale.ROOT)) {
                case ("blasting") ->
                        sender.sendMessage(lang.getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%crafts%", DefaultMethods.getCraftsNamesList("BlastingRecipe")).replace("%count%", DefaultMethods.getCraftsNamesListCount("BlastingRecipe")));
                case ("smithing") ->
                        sender.sendMessage(lang.getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%crafts%", DefaultMethods.getCraftsNamesList("SmithingRecipe")).replace("%count%", DefaultMethods.getCraftsNamesListCount("SmithingRecipe")));
                case ("smoking") ->
                        sender.sendMessage(lang.getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%crafts%", DefaultMethods.getFormattedList(SmokingCraft.getSmokingIds())).replace("%count%",String.valueOf(SmokingCraft.getSmokingIds().size())));
                case ("campfire") ->
                        sender.sendMessage(lang.getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%crafts%", DefaultMethods.getCraftsNamesList("CampfireRecipe")).replace("%count%", DefaultMethods.getCraftsNamesListCount("CampfireRecipe")));
                case ("stonecutter") ->
                        sender.sendMessage(lang.getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%crafts%", DefaultMethods.getFormattedList(StoneCutter.getStoneCutterIds())).replace("%count%",String.valueOf(StoneCutter.getStoneCutterIds().size())));
                case ("furnace") ->
                        sender.sendMessage(lang.getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%crafts%", DefaultMethods.getCraftsNamesList("FurnaceRecipe")).replace("%count%", DefaultMethods.getCraftsNamesListCount("FurnaceRecipe")));
                case ("trades") ->
                        sender.sendMessage(lang.getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%crafts%", DefaultMethods.getCraftsNamesList("VillagerTrade")).replace("%count%", DefaultMethods.getCraftsNamesListCount("VillagerTrade")));
                case ("all") ->
                        sender.sendMessage(lang.getMessage("list", StringUtils.FormatOption.WITHOUT_PLACEHOLDERS)
                                .replace("%crafts%", DefaultMethods.getAllCraftsNames()).replace("%count%", DefaultMethods.getAllCraftsCount()));
                default -> sender.sendMessage(lang.getMessage("invalid-command"));
            }
        } else {
            sender.sendMessage(lang.getMessage("invalid-command"));
        }

    }

    @Override
    public List<String> tabComplete(@NotNull final CommandSender sender, @NotNull final List<String> args) {

        List<String> completions = new ArrayList<>();

        completions.add("furnace");
        completions.add("stonecutter");
        completions.add("campfire");
        completions.add("smoking");
        completions.add("smithing");
        completions.add("blasting");
        completions.add("trades");
        completions.add("all");

        return completions;
    }
}
