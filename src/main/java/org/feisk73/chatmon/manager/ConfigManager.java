package org.feisk73.chatmon.manager;

import cn.nukkit.utils.Config;
import java.util.HashMap;

public class ConfigManager {
    private final Config config;
    private final HashMap<String, String> cachedStrings = new HashMap<>();
    private final HashMap<String, Integer> cachedInts = new HashMap<>();

    public ConfigManager(Config config) {
        this.config = config;
        reload();
    }

    public String getString(String key, String defaultValue) {
        return cachedStrings.computeIfAbsent(key, p -> config.getString(key, defaultValue));
    }
    public int getInt(String key, int defaultValue) {
        return cachedInts.computeIfAbsent(key, p -> config.getInt(key, defaultValue));
    }
    public void reload() {
        cachedStrings.clear();
        cachedInts.clear();
        config.reload();
    }
}
