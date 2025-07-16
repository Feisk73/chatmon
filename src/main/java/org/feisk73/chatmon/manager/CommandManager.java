package org.feisk73.chatmon.manager;

import org.feisk73.chatmon.Main;
import org.feisk73.chatmon.commands.ReloadCommand;

public class CommandManager {
    private final Main plugin;

    public CommandManager(Main plugin) {
        this.plugin = plugin;
    }

    public void registerCommands() {
        plugin.getServer().getCommandMap().register("chatmonreload", new ReloadCommand());
    }
}
