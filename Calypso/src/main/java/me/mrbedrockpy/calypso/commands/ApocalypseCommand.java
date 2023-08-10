package me.mrbedrockpy.calypso.commands;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.mrbedrockpy.calypso.Calypso;

public class ApocalypseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {
        if (commandSender.isOp()) {
            if (!(Calypso.onBossEvent)) {
                if (Calypso.onApocalypseEvent) {

                    Calypso.onApocalypseEvent = false;

                    String command = "title @a title {\"text\":\"Ивент заканчивается!\",\"color\":\"yellow\"}";
                    Server server = commandSender.getServer();
                    server.dispatchCommand(server.getConsoleSender(), command);

                    server.dispatchCommand(server.getConsoleSender(), "weather clear");
                    server.dispatchCommand(server.getConsoleSender(), "gamerule doWeatherCycle true");
                    server.dispatchCommand(server.getConsoleSender(), "gamerule doDaylightCycle true");
                    server.dispatchCommand(server.getConsoleSender(), "time set noon");

                } else {

                    Calypso.onApocalypseEvent = true;

                    String command = "title @a title {\"text\":\"Да начнется Апокалипсис!\",\"color\":\"red\"}";
                    Server server = commandSender.getServer();
                    server.dispatchCommand(server.getConsoleSender(), command);

                    server.dispatchCommand(server.getConsoleSender(), "weather thunder");
                    server.dispatchCommand(server.getConsoleSender(), "gamerule doWeatherCycle false");
                    server.dispatchCommand(server.getConsoleSender(), "gamerule doDaylightCycle false");
                    server.dispatchCommand(server.getConsoleSender(), "/time set midnight");

                }
                return true;
            }
            commandSender.sendMessage("Два ивента запускать нельзя!");
            return true;
        }
        return false;
    }

}
