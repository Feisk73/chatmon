package org.feisk73.chatmon.util;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerScanner {
    public static Player [] getPlayersNearby(Position position, int radius) {
        Collection<Player> onlinePlayers = Server.getInstance().getOnlinePlayers().values();
        List<Player> nearbyPlayers = new ArrayList<>();
        for (Player plr : onlinePlayers) {
            if (isWithinRadius(position, plr.getPosition(), radius* radius)) {
                nearbyPlayers.add(plr);
            }
        }

        return nearbyPlayers.toArray(new Player[0]);
    }
    private static boolean isWithinRadius(Position center,Position target, int radiusSquared) {
        double dx = center.getX() - target.getX();
        double dy = center.getY() - target.getY();
        double dz = center.getZ() - target.getZ();

        return dx * dx + dy * dy + dz * dz <= radiusSquared;
    }
}
