package org.feisk73.chatmon.manager;

import lombok.Getter;
import org.feisk73.chatmon.Main;

public class ProjectManager {
    private final Main plugin;
    @Getter
    private CommandManager commandManager;
    @Getter
    private EventManager eventManager;

    public ProjectManager(Main plugin) {
        this.plugin = plugin;
    }
    public void init() {
        commandManager = new CommandManager(plugin);
        eventManager = new EventManager(plugin);
    }

}
