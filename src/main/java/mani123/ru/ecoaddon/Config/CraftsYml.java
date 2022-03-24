package mani123.ru.ecoaddon.Config;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.config.BaseConfig;
import com.willfp.eco.core.config.ConfigType;

public class CraftsYml extends BaseConfig {

    public CraftsYml(EcoPlugin plugin) {
        super("crafts", plugin, true, ConfigType.YAML);
    }
}