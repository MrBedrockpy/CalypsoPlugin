package me.mrbedrockpy.calypso.events;

import me.mrbedrockpy.calypso.Calypso;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AdminWhiteListEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.isOp() && Calypso.onAdminWhiteList) {
            player.kickPlayer("На сервере проводятся тех работы.");
        }
    }

}
