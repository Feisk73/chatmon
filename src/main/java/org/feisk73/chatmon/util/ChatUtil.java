package org.feisk73.chatmon.util;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;

public class ChatUtil {
    public static String formatChat(String unformattedString, String chatType, Player player, String message) {
        String formatted = unformattedString
                .replace("%chat_type%", chatType + TextFormat.RESET)
                .replace("%name%", player.getDisplayName())
                .replace("%msg%", message);
        return PlaceholderUtil.translateString(formatted, player);
    }
}
