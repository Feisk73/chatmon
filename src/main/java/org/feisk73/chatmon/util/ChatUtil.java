package org.feisk73.chatmon.util;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;

public class ChatUtil {
    public static String formatChat(String chatType, Player player, String message) {
        String unformattedString = ConfigUtil.getString("chat-format", "%chat_type% | %luckperms_prefix% <%name%> %msg%")
                .replace("%chat_type%", chatType + TextFormat.RESET)
                .replace("%name%", player.getDisplayName())
                .replace("%msg%", message);
        return PlaceholderUtil.translateString(unformattedString, player);
    }
}
