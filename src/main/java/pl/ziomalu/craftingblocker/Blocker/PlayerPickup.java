package pl.ziomalu.craftingblocker.Blocker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import pl.ziomalu.craftingblocker.CraftingBlocker;

public class PlayerPickup implements Listener {
    @EventHandler
    public void pickup(PlayerPickupItemEvent e){
        if (e.getPlayer().hasPermission("ziomalu.blockedcrafting.bypass")) return;
        if (CraftingBlocker.getInstance().disableMaterials.contains(e.getItem().getItemStack().getType())){
            e.setCancelled(true);
        }
    }
}
