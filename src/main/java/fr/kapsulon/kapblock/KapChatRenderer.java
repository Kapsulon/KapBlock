package fr.kapsulon.kapblock;

import io.papermc.paper.chat.ChatRenderer;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

public class KapChatRenderer implements ChatRenderer {
    @Override
    public Component render(Player source, Component sourceDisplayName, Component message, Audience viewer) {
        return Component.text()
                .append(Component.text("[Kap] ").color(TextColor.color(255, 0, 0)))
                .append(sourceDisplayName.clickEvent(source.displayName().clickEvent()))
                .append(Component.text(" » "))
                .append(message)
                .build();
    }
}
