package fr.kapsulon.kapblock.commands;

import fr.kapsulon.kapblock.KapBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Info implements CommandExecutor {
    private final KapBlock plugin;

    public Info(KapBlock plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        plugin.getLogger().info("info");
        return true;
    }
}
