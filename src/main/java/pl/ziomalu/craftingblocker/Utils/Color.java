package pl.ziomalu.craftingblocker.Utils;

import org.bukkit.ChatColor;

public class Color {
    public static String setColor(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
