package org.feisk73.chatmon.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import org.feisk73.chatmon.Main;
import org.feisk73.chatmon.handler.ChatHandler;

public class ChatListener implements Listener {
    private final ChatHandler chatHandler;
    public ChatListener(Main plugin) {
        chatHandler = new ChatHandler(plugin);
    }

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();
        e.setCancelled();
        chatHandler.handle(player, message);
    }
}
