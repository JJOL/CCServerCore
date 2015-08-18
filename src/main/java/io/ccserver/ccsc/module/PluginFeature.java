package io.ccserver.ccsc.module;

/**
 * Created by JJOL on 17/08/2015.
 */
public abstract class PluginFeature {

    protected final PluginModule PLUGIN;

    public PluginFeature(PluginModule plugin) {
        PLUGIN = plugin;
    }

    public abstract void register();

    public void enable() {

    }

    public void disable() {

    }

}
