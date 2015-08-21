package io.ccserver.ccsc;

import io.ccserver.ccsc.listeners.PlayerListener;
import io.ccserver.ccsc.module.PluginModule;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by JJOL on 14/08/2015.
 */

public class CCServerCore extends PluginModule {

    public static CCServerCore INSTANCE;
    public static CCServerCore get() { return INSTANCE; }

    public CCServerCore() { INSTANCE = this; }

    public void onEnable() {
        add("PlayerJoin", new PlayerListener(this));
        setupModule();
    }


    public void onDisable() {
    }
}
