package pl.ziomalu.craftingblocker.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.ziomalu.craftingblocker.CraftingBlocker;
import pl.ziomalu.craftingblocker.Utils.Color;

public class CraftingBlockerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("ziomalu.craftingblocked.use")) return true;
        if (args.length == 2){
            if (args[0].equalsIgnoreCase("enable")){
                if (args[1].equalsIgnoreCase("iron")){
                    CraftingBlocker.getInstance().getConfig().set("disable-craftings.iron.disable", false);
                    CraftingBlocker.getInstance().saveConfig();
                    CraftingBlocker.getInstance().disableCrafting();
                    sender.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.iron.message-enable")));

                }else if (args[1].equalsIgnoreCase("gold")){
                    CraftingBlocker.getInstance().getConfig().set("disable-craftings.gold.disable", false);
                    CraftingBlocker.getInstance().saveConfig();
                    CraftingBlocker.getInstance().disableCrafting();
                    sender.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.gold.message-enable")));

                }else if (args[1].equalsIgnoreCase("diamond")){
                    CraftingBlocker.getInstance().getConfig().set("disable-craftings.diamond.disable", false);
                    CraftingBlocker.getInstance().saveConfig();
                    CraftingBlocker.getInstance().disableCrafting();
                    sender.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.diamond.message-enable")));

                } else if (args[1].equalsIgnoreCase("netherite")){
                    CraftingBlocker.getInstance().getConfig().set("disable-craftings.netherite.disable", false);
                    CraftingBlocker.getInstance().saveConfig();
                    CraftingBlocker.getInstance().disableCrafting();
                    sender.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.netherite.message-enable")));

                }
            }else if (args[0].equalsIgnoreCase("disable")){
                if (args[1].equalsIgnoreCase("iron")){
                    CraftingBlocker.getInstance().getConfig().set("disable-craftings.iron.disable", true);
                    CraftingBlocker.getInstance().saveConfig();
                    CraftingBlocker.getInstance().disableCrafting();
                    sender.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.iron.message-disable")));

                }else if (args[1].equalsIgnoreCase("gold")){
                    CraftingBlocker.getInstance().getConfig().set("disable-craftings.gold.disable", true);
                    CraftingBlocker.getInstance().saveConfig();
                    CraftingBlocker.getInstance().disableCrafting();
                    sender.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.gold.message-disable")));

                }else if (args[1].equalsIgnoreCase("diamond")){
                    CraftingBlocker.getInstance().getConfig().set("disable-craftings.diamond.disable", true);
                    CraftingBlocker.getInstance().saveConfig();
                    CraftingBlocker.getInstance().disableCrafting();
                    sender.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.diamond.message-disable")));

                } else if (args[1].equalsIgnoreCase("netherite")){
                    CraftingBlocker.getInstance().getConfig().set("disable-craftings.netherite.disable", true);
                    CraftingBlocker.getInstance().saveConfig();
                    CraftingBlocker.getInstance().disableCrafting();
                    sender.sendMessage(Color.setColor(CraftingBlocker.getInstance().getConfig().getString("disable-craftings.netherite.message-disable")));

                }
            }
        }
        return false;
    }
}
