package pl.ziomalu.craftingblocker.Blocker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import pl.ziomalu.craftingblocker.CraftingBlocker;
import pl.ziomalu.craftingblocker.Utils.Color;

public class PlayerCraft implements Listener {

    @EventHandler
    public void onCrafting(PrepareItemCraftEvent e){

        if(e.getViewers().isEmpty()) {
            return;
        }
        if(e.getRecipe() == null || e.getRecipe().getResult() == null || e.getRecipe().getResult().getType() == Material.AIR ||
        e.getInventory().getRecipe() == null || e.getInventory().getResult() == null || e.getInventory().getResult().getType() == Material.AIR) {
            return;
        }



       /* for (HumanEntity entity : e.getViewers()){
            if (entity instanceof Player){
                if (entity.hasPermission("ziomalu.blockedcrafting.bypass")) return;
            }
        }*/

        Material mat = e.getRecipe().getResult().getType();

        if (CraftingBlocker.getInstance().disableMaterials.contains(mat)){
            e.getInventory().setResult(new ItemStack(Material.AIR));

            for (HumanEntity entity : e.getViewers()){
                if (entity instanceof Player) {
                    if (mat.name().toLowerCase().contains("iron")) {
                        entity.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.iron.message-crafting")));
                        // iron
                    } else if (mat.name().toLowerCase().contains("golden")) {
                        entity.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.gold.message-crafting")));
                        // golden
                    } else if (mat.name().toLowerCase().contains("diamond")) {
                        entity.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.diamond.message-crafting")));
                        // diamond
                    } else if (mat.name().toLowerCase().contains("netherite")) {
                        entity.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.netherite.message-crafting")));
                        // netherite
                    }
                }
            }
        }
    }
}
