package io.ccserver.ccsc.commands;

import org.bukkit.command.*;

import java.util.List;

/**
 * Created by JJOL on 17/08/2015.
 */
public abstract class SubCommand implements CommandExecutor, TabCompleter, ModuleCommand {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return onCommand(sender, label, args);
    }

    public abstract boolean onCommand(CommandSender sender, String label, String[] args);

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        return onTabComplete(sender, label, args);
    }

    public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
        return null;
    }



}
