package mani123.ru.ecoaddon.Config;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.PluginLike;
import com.willfp.eco.core.config.BaseConfig;
import com.willfp.eco.core.config.ConfigType;
import org.jetbrains.annotations.NotNull;

public class CraftsYml extends BaseConfig {

    public CraftsYml(EcoPlugin plugin) {
        super("crafts", plugin, false, ConfigType.YAML);
    }
}
