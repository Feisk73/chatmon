package org.feisk73.chatmon.manager;

import org.feisk73.chatmon.Main;
import org.feisk73.chatmon.listener.ChatListener;

public class EventManager {
    private final Main plugin;

    public EventManager(Main plugin) {
        this.plugin = plugin;
    }
    public void regEvents() {
        plugin.getServer().getPluginManager().registerEvents(new ChatListener(plugin), plugin);
    }
}
