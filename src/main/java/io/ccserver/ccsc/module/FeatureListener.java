package io.ccserver.ccsc.module;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 * Created by JJOL on 17/08/2015.
 */
public class FeatureListener extends PluginFeature implements Listener{

    private boolean active;

    public FeatureListener(PluginModule plugin) {
        super(plugin);
    }

    @Override
    public void register() {
        PLUGIN.getServer().getPluginManager().registerEvents(this, PLUGIN);
        active = true;
    }

    @Override
    public void enable() {
        if(!active) {
            register();
        }
    }

    @Override
    public void disable() {
        HandlerList.unregisterAll(this);
        active = false;
    }
}
