package io.ccserver.ccsc.utils;

import org.bukkit.ChatColor;

/**
 * Created by JJOL on 17/08/2015.
 */
public class BukkitUtils {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
