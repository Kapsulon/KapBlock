package fr.kapsulon.kapblock;

import fr.kapsulon.kapblock.commands.Info;
import fr.kapsulon.kapblock.events.OnAsyncChat;
import fr.kapsulon.kapblock.tasks.DistributeItems;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public final class KapBlock extends JavaPlugin {
    public void giveOrDrop(Player player, ItemStack item) {
        HashMap<Integer, ItemStack> leftOver = new HashMap<Integer, ItemStack>();
        leftOver.putAll(player.getInventory().addItem(item));
        if (!leftOver.isEmpty()) {
            for (ItemStack i : leftOver.values()) {
                player.getWorld().dropItemNaturally(player.getLocation(), i);
            }
        }
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnAsyncChat(this), this);
        getCommand("info").setExecutor(new Info(this));
        BukkitTask distributeItemsTask = new DistributeItems(this).runTaskTimer(this, 0, 1*20);
    }
}
