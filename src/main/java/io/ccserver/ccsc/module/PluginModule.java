package io.ccserver.ccsc.module;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJOL on 17/08/2015.
 */
public abstract class PluginModule extends JavaPlugin {

    protected final Map<String, CommandExecutor> commandMap = new HashMap<>();
    protected final Map<String, PluginFeature> featureMap   = new HashMap<>();

    private final void registerCommands() {
        for(String cmdName : commandMap.keySet()) {
            getCommand(cmdName).setExecutor(commandMap.get(cmdName));
        }
    }

    private final void registerFeatures() {
        for (String name : featureMap.keySet()) {
            featureMap.get(name).register();
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
