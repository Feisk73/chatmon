package org.feisk73.chatmon.util;

import cn.nukkit.utils.Config;
import org.feisk73.chatmon.Main;

import java.util.HashMap;

public class ConfigUtil {
    private static Main plugin;
    private static Config config;
    private static final HashMap<String, String> cachedStrings = new HashMap<>();
    private static final HashMap<String, Integer> cachedInts = new HashMap<>();

    public static void init(Main plugin) {
        ConfigUtil.plugin = plugin;
        config = plugin.getConfig();
        reload();
    }
    public static String getString(String key, String defaultValue) {
        return cachedStrings.computeIfAbsent(key, p -> config.getString(key, defaultValue));
    }
    public static int getInt(String key, int defaultValue) {
        return cachedInts.computeIfAbsent(key, p -> config.getInt(key, defaultValue));
    }
    public static void reload() {
        cachedStrings.clear();
        cachedInts.clear();

        plugin.reloadConfig();
        config = plugin.getConfig();
    }
}
