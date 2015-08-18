package io.ccserver.ccsc.module;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 * Created by JJOL on 17/08/2015.
 */
public class FeatureListener extends PluginFeature implements Listener{


    public FeatureListener(PluginModule plugin) {
        super(plugin);
    }

    @Override
    public void register() {
        PLUGIN.getServer().getPluginManager().registerEvents(this, PLUGIN);
    }

    @Override
    public void enable() {
        register();
    }

    @Override
    public void disable() {
        HandlerList.unregisterAll(this);
    }
}
