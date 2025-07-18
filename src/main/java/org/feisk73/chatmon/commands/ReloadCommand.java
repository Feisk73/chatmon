package org.feisk73.chatmon.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import org.feisk73.chatmon.Main;

public class ReloadCommand extends Command {
    private final Main plugin;
    public ReloadCommand(Main plugin) {
        super("chatmonreload", "Reload chatmon config", "/chatmon");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission("chatmon.command.reload")) {
            sender.sendMessage(TextFormat.RED + "У вас недостаточно прав на использование данной команды");
            return true;
        }
        plugin.getConfigManager().reload();
        sender.sendMessage("[Chatmon] Конфиг был перезагружен");
        return true;
    }
}
