package me.mrbedrockpy.calypso.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatManagerEvent implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        if (containsCaps(message)) {
            String cursorship = "";
            for (char c : message.toCharArray()) {
                if (Character.isSpaceChar(c)) {
                    cursorship += " ";
                }
                if (Character.isLetter(c)) {
                    cursorship += "*";
                }
            }
        }
    }

    private boolean containsCaps(String message) {
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c) && !(Character.isUpperCase(c))) {
                return false;
            }
        }
        return true;
    }

}
