package org.feisk73.chatmon.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import org.feisk73.chatmon.util.ConfigUtil;

public class ReloadCommand extends Command {

    public ReloadCommand() {
        super("chatmonreload", "Reload chatmon config", "/chatmon");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission("chatmon.command.reload")) {
            sender.sendMessage(TextFormat.RED + "У вас недостаточно прав на использование данной команды");
            return true;
        }
        ConfigUtil.reload();
        sender.sendMessage("[Chatmon] Конфиг был перезагружен");
        return true;
    }
}
