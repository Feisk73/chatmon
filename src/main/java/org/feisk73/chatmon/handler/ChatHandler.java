package org.feisk73.chatmon.handler;

import cn.nukkit.Player;
import org.feisk73.chatmon.Main;
import org.feisk73.chatmon.manager.ConfigManager;
import org.feisk73.chatmon.util.ChatUtil;
import org.feisk73.chatmon.util.PlayerScanner;

public class ChatHandler {
    private final Main plugin;
    private final ConfigManager configManager;
    private String message;

    private final String GLOBAL;
    private final String LOCAL;
    private final String RAW_CHAT_FORMAT;

    public ChatHandler(Main plugin) {
        this.plugin = plugin;
        configManager = plugin.getConfigManager();
        GLOBAL = configManager.getString("scope-label.global", "§6G");
        LOCAL = configManager.getString("scope-label.local", "§aL");
        RAW_CHAT_FORMAT = configManager.getString("chat-format", "%chat_type% | %luckperms_prefix% <%name%> %msg%");

    }

    public void handle(Player sender, String message) {


        this.message = message;
        // Глобал чат
        if (isGlobalChat()) {
            plugin.getServer().broadcastMessage(ChatUtil.formatChat(
                    RAW_CHAT_FORMAT,
                    GLOBAL,
                    sender,
                    message.substring(1))
            );
            return;
        }
        // Лакал чат
        Player[] nearbyPlayers = PlayerScanner.getPlayersNearby(sender.getPosition(), configManager.getInt("radius", 100));
        // каждаму играку собщения кидаем
        for (Player player : nearbyPlayers) {
            player.sendChat(ChatUtil.formatChat(
                    RAW_CHAT_FORMAT,
                    LOCAL,
                    sender,
                    message)
            );
        }
        // Никаго нет
        if (nearbyPlayers.length == 1 ) {
            sender.sendChat(configManager.getString("messages.no-one-around", "§7Ваше сообщение никто не услышал. Попробуйте написать \"!\" перед своим сообщением"));
        }
    }
    private boolean isGlobalChat() {
        return message.startsWith(configManager.getString("globalChatPrefix", "!"));
    }
}
