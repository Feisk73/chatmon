package org.feisk73.chatmon.util;

import cn.nukkit.Player;
import com.creeperface.nukkit.placeholderapi.api.PlaceholderAPI;

public class PlaceholderUtil {
    private static final PlaceholderAPI api = PlaceholderAPI.getInstance();
    public static String getPlaceholder(String key) {
        return api.getValue(key);
    }
    public static String getPlaceholder(String key, Player player) {
        return api.getValue(key, player);
    }
    public static String translateString(String string) {
        return api.translateString(string);
    }
    public static String translateString(String string, Player player) {
        return api.translateString(string, player);
    }
}
