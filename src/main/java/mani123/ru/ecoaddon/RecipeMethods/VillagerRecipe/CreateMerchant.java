package mani123.ru.ecoaddon.RecipeMethods.VillagerRecipe;

import com.willfp.eco.core.items.Items;
import mani123.ru.ecoaddon.EcoAddon;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class CreateMerchant {

/*
     public void CreateMerchantTrade(Villager event) {
         if (EcoAddon.getPlugin().getConfigYml().getBool("enableVillagerTrades")) {
             for (int i = 0; i < EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").size(); i++) {
                 double chance = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getDouble("chance") / 100;
                 double randomChance = Math.random();
                 System.out.println("1");
                 if (randomChance <= chance) {
                     String type = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getString("type").toLowerCase().trim();
                     System.out.println("2 " + event.getProfession().getKey().getKey() + "  " + type);
                     if (event.getProfession().getKey().getKey().equals(type)) {
                         System.out.println("3");
                         int level = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("level") - 1;
                         if (level <= event.getRecipes().size()) {
                             System.out.println("4");
                             System.out.println(level + " " + event.getRecipes().size());
                             ItemStack result = Items.lookup(EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getFormattedString("result")).getItem();
                             ItemStack inputOne = Items.lookup(EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getFormattedString("inputOne")).getItem();
                             ItemStack inputTwo = Items.lookup(EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getFormattedString("inputTwo")).getItem();
                             int uses = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("uses");
                             int maxUses = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("maxUses");
                             int villagerExperience = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("villagerExperience");
                             int demand = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("demand");
                             int specialPrice = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getInt("specialPrice");
                             float priceMultiplier = (float) EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getDouble("priceMultiplier");
                             boolean experienceReward = EcoAddon.getPlugin().getCraftsYml().getSubsections("VillagerTrade").get(i).getBool("experienceReward");
                             MerchantRecipe merchantRecipe = new MerchantRecipe(result, uses, maxUses, experienceReward, villagerExperience, priceMultiplier, demand, specialPrice);
                             if (inputOne.getType() != Material.AIR) {
                                 merchantRecipe.addIngredient(inputOne);
                             }
                             if (inputTwo.getType() != Material.AIR) {
                                 merchantRecipe.addIngredient(inputTwo);
                             }
                             System.out.println("5");
                             event.setRecipe(level, merchantRecipe);
                         }
                     }
                 }
             }
         }
     }
 */

}
