package me.faun.preventcustomcrafting;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class PreventCustomCrafting extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        //Plugin disable
    }

    @EventHandler
    public void onPlayerCraft(PrepareItemCraftEvent event) {
        ItemStack[] item = event.getInventory().getMatrix();
        for (ItemStack itemStack : item) {
            if (itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().hasCustomModelData()) {
                    event.getInventory().setResult(null);
                    break;
            }
        }
    }
}
