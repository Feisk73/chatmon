package org.feisk73.chatmon;

import cn.nukkit.plugin.PluginBase;
import lombok.Getter;
import org.feisk73.chatmon.manager.ConfigManager;
import org.feisk73.chatmon.manager.ProjectManager;

public class Main extends PluginBase {
    @Getter
    private ProjectManager projectManager;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        projectManager = new ProjectManager(this);
        projectManager.init();
        projectManager.getCommandManager().registerCommands();
        projectManager.getEventManager().regEvents();

        this.getLogger().info("enabled");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("disabled");
    }

    public ConfigManager getConfigManager() {
        return projectManager.getConfigManager();
    }
}