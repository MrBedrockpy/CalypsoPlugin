package me.mrbedrockpy.calypso;

import me.mrbedrockpy.calypso.commands.*;

import me.mrbedrockpy.calypso.events.*;

import org.bukkit.plugin.java.JavaPlugin;

public final class Calypso extends JavaPlugin {

    public static boolean onAdminWhiteList = false;

    public static boolean onApocalypseEvent = false;

    public static boolean onBossEvent = false;

    @Override
    public void onEnable() {
        System.out.println("Calypso plugin is started!");

        //Импорт комманд
        getCommand("infoplayers").setExecutor(new InfoPlayersCommand());
        getCommand("apocalypseevent").setExecutor(new ApocalypseCommand());
        getCommand("adminwhitelist").setExecutor(new AdminWhiteListCommand());
        getCommand("bossevent").setExecutor(new spawnBossCommand());

        //Импорт ивентов
        getServer().getPluginManager().registerEvents(new AdminWhiteListEvent(), this);
        getServer().getPluginManager().registerEvents(new ApocalypseEvent(), this);
        getServer().getPluginManager().registerEvents(new ChatManagerEvent(), this);
    }

    public static boolean onEnderEvents() {
        if (onApocalypseEvent || onBossEvent) {
            return true;
        }
        return false;
    }
}
