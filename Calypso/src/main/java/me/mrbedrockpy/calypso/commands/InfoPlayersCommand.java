package me.mrbedrockpy.calypso.commands;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;

public class InfoPlayersCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender.isOp()) {
            Server server = commandSender.getServer();
            Player[] players = server.getOnlinePlayers().toArray(new Player[0]);

            for (Player player : players) {

                Location location = player.getLocation();

                int x = (int) location.getX();
                int y = (int) location.getY();
                int z = (int) location.getZ();

                String message = "Имя: " + player.getName() + " Здоровье: " + String.valueOf((int) player.getHealth()) + " Координаты: " + String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(z) + " " + " Измерение: " + player.getWorld().getName();

                commandSender.sendMessage(message);
            }
            return true;
        }
        return false;
    }
}