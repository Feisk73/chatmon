package org.feisk73.chatmon;

import cn.nukkit.plugin.PluginBase;
import lombok.Getter;
import org.feisk73.chatmon.manager.ProjectManager;
import org.feisk73.chatmon.util.ConfigUtil;

public class Main extends PluginBase {
    @Getter
    private ProjectManager projectManager;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        ConfigUtil.init(this);
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
}