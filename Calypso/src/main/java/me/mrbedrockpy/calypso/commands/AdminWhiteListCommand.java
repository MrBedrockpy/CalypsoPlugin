package me.mrbedrockpy.calypso.commands;

import me.mrbedrockpy.calypso.Calypso;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminWhiteListCommand implements CommandExecutor {

    public static void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.isOp()) {
            if (!(Calypso.onAdminWhiteList)) {

                Server server = commandSender.getServer();
                Player[] players = server.getOnlinePlayers().toArray(new Player[0]);

                for (int i = 0; i < players.length; i++) {
                        players[i].sendMessage("Через 10 секунд на сервере начнутся тех работы");
                }

                delay(10);

                for (int i = 0; i < players.length; i++) {
                    players[i].sendMessage("Тех работы начались");
                }

                Calypso.onAdminWhiteList = true;
                for (int i = 0; i < players.length; i++) {
                    if (!(players[i].isOp()))
                        players[i].kickPlayer("На сервере проводятся технические работы!");
                }
            } else {
                Calypso.onAdminWhiteList = false;
                commandSender.sendMessage("Тех работы закончены!");
            }
            return true;
        }
        return false;
    }
}
