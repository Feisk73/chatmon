package org.feisk73.chatmon.manager;

import lombok.Getter;
import org.feisk73.chatmon.Main;

public class ProjectManager {
    private final Main plugin;
    @Getter
    private CommandManager commandManager;
    @Getter
    private EventManager eventManager;
    @Getter
    private ConfigManager configManager;

    public ProjectManager(Main plugin) {
        this.plugin = plugin;
    }
    public void init() {
        configManager = new ConfigManager(plugin.getConfig());
        commandManager = new CommandManager(plugin);
        eventManager = new EventManager(plugin);
    }

}
