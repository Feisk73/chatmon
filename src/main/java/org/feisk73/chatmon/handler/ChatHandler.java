package org.feisk73.chatmon.handler;

import cn.nukkit.Player;
import org.feisk73.chatmon.Main;
import org.feisk73.chatmon.util.ChatUtil;
import org.feisk73.chatmon.util.ConfigUtil;
import org.feisk73.chatmon.util.PlayerScanner;

public class ChatHandler {
    private final Main plugin;
    private String message;

    public ChatHandler(Main plugin) {
        this.plugin = plugin;
    }

    public void handle(Player sender, String message) {
        this.message = message;
        // Глобал чат
        if (isGlobalChat()) {
            plugin.getServer().broadcastMessage(ChatUtil.formatChat(
                    ConfigUtil.getString("scope-label.global", "§6G"),
                    sender,
                    message.substring(1))
            );
            return;
        }
        // Лакал чат
        Player[] nearbyPlayers = PlayerScanner.getPlayersNearby(sender.getPosition(), ConfigUtil.getInt("radius", 100));
        if (nearbyPlayers.length == 0 ) {
            sender.sendChat(ConfigUtil.getString("messages.no-one-around", "§7Ваше сообщение никто не услышал. Попробуйте написать \"!\" перед своим сообщением"));
        }
        // каждаму играку собщения кидаем
        for (Player player : nearbyPlayers) {
            player.sendChat(ChatUtil.formatChat(
                    ConfigUtil.getString("scope-label.local", "§aL"),
                    sender,
                    message)
            );
        }
    }
    private boolean isGlobalChat() {
        return message.startsWith(ConfigUtil.getString("globalChatPrefix", "!"));
    }
}
