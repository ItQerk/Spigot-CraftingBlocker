package pl.ziomalu.craftingblocker;

import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import pl.ziomalu.craftingblocker.Blocker.PlayerCraft;
import pl.ziomalu.craftingblocker.Blocker.PlayerPickup;
import pl.ziomalu.craftingblocker.Command.CraftingBlockerCommand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CraftingBlocker extends JavaPlugin {

    private static CraftingBlocker instance;
    public List<Material> disableMaterials = new ArrayList<Material>();
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getCommand("craftingblocker").setExecutor(new CraftingBlockerCommand());
        //backupRecipes = getServer().recipeIterator();
        disableCrafting();
        getServer().getPluginManager().registerEvents(new PlayerCraft(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickup(), this);
    }

    @Override
    public void onDisable() {

    }

    public static CraftingBlocker getInstance(){
        return instance;
    }

    public void disableCrafting(){
        disableMaterials.clear();
        List<Material> iron = new ArrayList<Material>();
        List<Material> gold = new ArrayList<Material>();
        List<Material> diamond = new ArrayList<Material>();
        List<Material> netherite = new ArrayList<Material>();

        for (String mat : getConfig().getStringList("disable-craftings.iron.items")) {
            if (getConfig().getBoolean("disable-craftings.iron.disable")) {
                if (mat != null)
                    iron.add(Material.valueOf(mat.toUpperCase()));
            }
        }


        for (String mat : getConfig().getStringList("disable-craftings.gold.items")){
            if (getConfig().getBoolean("disable-craftings.gold.disable")) {
                if (mat != null)
                    gold.add(Material.valueOf(mat.toUpperCase()));
            }
        }

        for (String mat : getConfig().getStringList("disable-craftings.diamond.items")){
            if (getConfig().getBoolean("disable-craftings.diamond.disable")) {
                if (mat != null)
                    diamond.add(Material.valueOf(mat.toUpperCase()));
            }
        }

        for (String mat : getConfig().getStringList("disable-craftings.netherite.items")){
            if (getConfig().getBoolean("disable-craftings.netherite.disable")) {
                if (mat != null)
                    netherite.add(Material.valueOf(mat.toUpperCase()));
            }
        }

        disableMaterials.addAll(iron);
        disableMaterials.addAll(gold);
        disableMaterials.addAll(diamond);
        disableMaterials.addAll(netherite);
    }
}
