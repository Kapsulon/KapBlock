package fr.kapsulon.kapblock.tasks;

import fr.kapsulon.kapblock.KapBlock;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public class DistributeItems extends BukkitRunnable {
    private final KapBlock plugin;

    public DistributeItems(KapBlock plugin) {
        this.plugin = plugin;
    }

    private void distribute(Player player) {
        Material[] materials = Material.values();
        Random rng = new Random();
        Material material = materials[rng.nextInt(0, materials.length)];
        while (!material.isItem() || material.isEmpty()) {
            material = materials[rng.nextInt(0, materials.length)];
        }
        ItemStack item = new ItemStack(material, 1);
        plugin.giveOrDrop(player, item);
    }

    int i = 0;

    @Override
    public void run() {
        if (i >= 30) {
            i = 0;
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getGameMode() != GameMode.CREATIVE && player.getGameMode() != GameMode.SPECTATOR) {
                    distribute(player);
                }
            }
        }
        i++;
    }
}
