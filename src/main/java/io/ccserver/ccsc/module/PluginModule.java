package io.ccserver.ccsc.module;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJOL on 17/08/2015.
 */
public abstract class PluginModule extends JavaPlugin {

    private final Map<String, CommandExecutor> COMMAND_MAP = new HashMap<>();
    private final Map<String, PluginFeature> FEATURES_MAP   = new HashMap<>();

    private final void registerCommands() {
        for(String cmdName : COMMAND_MAP.keySet()) {
            getCommand(cmdName).setExecutor(COMMAND_MAP.get(cmdName));
        }
    }

    private final void registerFeatures() {
        for (String name : FEATURES_MAP.keySet()) {
            FEATURES_MAP.get(name).register();
        }
    }

    protected void add(String name, PluginFeature feature) {
        FEATURES_MAP.put(name, feature);
    }

    protected void add(String name, CommandExecutor commandExecutor) {
        COMMAND_MAP.put(name, commandExecutor);
    }

    public void turnOnFeature(String feature) {
        if(FEATURES_MAP.containsKey(feature)) {
            FEATURES_MAP.get(feature).enable();
        }
    }

    public void turnOffFeature(String feature) {
        if(FEATURES_MAP.containsKey(feature)) {
            FEATURES_MAP.get(feature).disable();
        }
    }

    /**
     * This Method Setups the Defaults for any Modular Plugin
     * This must be called at Server Initialization, preferably onEnable() method after the Module Properties have been specified
     */
    protected final void setupModule() {
        registerCommands();
        registerFeatures();
    }

}
