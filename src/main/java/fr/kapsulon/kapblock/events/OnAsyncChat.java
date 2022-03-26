package fr.kapsulon.kapblock.events;

import fr.kapsulon.kapblock.KapBlock;
import fr.kapsulon.kapblock.KapChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnAsyncChat implements Listener {
    private final KapBlock plugin;

    public OnAsyncChat(KapBlock plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        Player player = event.getPlayer();

        KapChatRenderer kapChatRenderer = new KapChatRenderer();
        event.renderer(kapChatRenderer);
    }
}