package mani123.ru.ecoaddon.RecipeMethods.VillagerRecipe;

import com.willfp.eco.core.PluginDependent;
import com.willfp.eco.core.items.Items;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

public class VillagerListeners extends PluginDependent<EcoAddon> implements Listener {

    public VillagerListeners(@NotNull final EcoAddon plugin) {
        super(plugin);
    }

    @EventHandler
    public void onEntitySpawnEvent(@NotNull final VillagerAcquireTradeEvent event) {
        if (this.getPlugin().getConfigYml().getBool("enableStoneCutter")) {
            for (int i = 0; i < this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").size(); i++) {
                double chance = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getDouble("chance") / 100;
                double randomChance = Math.random();
                if (randomChance <= chance) {
                    String type = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getString("type").toLowerCase().trim();
                    Villager villager = (Villager) event.getEntity();
                    if (villager.getProfession().getKey().getNamespace().equals("minecraft:" + type)) {
                        int level = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("level");
                        if (villager.getVillagerLevel() == level || villager.getVillagerLevel() == 0) {
                            ItemStack result = Items.lookup(this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getFormattedString("result")).getItem();
                            ItemStack inputOne = Items.lookup(this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getFormattedString("inputOne")).getItem();
                            ItemStack inputTwo = Items.lookup(this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getFormattedString("inputTwo")).getItem();
                            int uses = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("uses");
                            int maxUses = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("maxUses");
                            int villagerExperience = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("villagerExperience");
                            int demand = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("demand");
                            int specialPrice = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("specialPrice");
                            float priceMultiplier = (float) this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getDouble("priceMultiplier");
                            boolean experienceReward = this.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getBool("experienceReward");
                            MerchantRecipe merchantRecipe = new MerchantRecipe(result, uses, maxUses, experienceReward, villagerExperience, priceMultiplier, demand, specialPrice);
                            if (inputOne.getType() != Material.AIR) {
                                merchantRecipe.addIngredient(inputOne);
                            }
                            if (inputTwo.getType() != Material.AIR) {
                                merchantRecipe.addIngredient(inputTwo);
                            }
                            event.setRecipe(merchantRecipe);
                        }
                    }
                }
            }
        }
    }
}
