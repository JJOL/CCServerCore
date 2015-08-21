package io.ccserver.ccsc.listeners;

import io.ccserver.ccsc.events.PlayerFirstTimeJoinEvent;
import io.ccserver.ccsc.module.FeatureListener;
import io.ccserver.ccsc.module.PluginModule;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by JJOL on 18/08/2015.
 */
public class PlayerListener extends FeatureListener {

    public PlayerListener(PluginModule plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        //TODO Check Database and see if this is the first time that the player joins
        boolean firstTime = true;
        if (firstTime) {
            Bukkit.getPluginManager().callEvent(new PlayerFirstTimeJoinEvent(event.getPlayer()));
        }
    }

}
