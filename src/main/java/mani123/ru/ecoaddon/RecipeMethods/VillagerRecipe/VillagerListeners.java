package mani123.ru.ecoaddon.RecipeMethods.VillagerRecipe;

import com.willfp.eco.core.PluginDependent;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.event.entity.VillagerReplenishTradeEvent;
import org.jetbrains.annotations.NotNull;

public class VillagerListeners extends PluginDependent<EcoAddon> implements Listener {

    public VillagerListeners(@NotNull final EcoAddon plugin) {
        super(plugin);
    }

    CreateMerchant createMerchant = new CreateMerchant();

    @EventHandler
    public void VillagerAcquireTradeEvent(@NotNull final VillagerAcquireTradeEvent event) {
        createMerchant.CreateMerchantTrade((Villager) event.getEntity());
        event.setCancelled(true);
        System.out.println(event.isCancelled());
    }

    @EventHandler
    public void VillagerCareerChangeEvent(@NotNull final VillagerCareerChangeEvent event) {
        createMerchant.CreateMerchantTrade(event.getEntity());
    }


}
