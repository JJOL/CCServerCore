package io.ccserver.ccsc.commands;

import com.google.common.collect.Lists;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by JJOL on 17/08/2015.
 */
public abstract class MainCommand implements CommandExecutor, TabCompleter{

    protected Map<String, CommandExecutor> commandMap = new HashMap<String, CommandExecutor>();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(getUsage());
            return true;
        }

        String subCommandName = args[0].toLowerCase();

        if (commandMap.containsKey(subCommandName)) {
            sender.sendMessage(getUsage());
            return true;
        }


        CommandExecutor subCommand = commandMap.get(subCommandName);

        if(!hasPermission((Player)sender, subCommand)) {
            sender.sendMessage("No Permission");
            //TODO Insufficient Permissions
        }

        return subCommand.onCommand(sender, cmd, args[0], getSubCommandArgs(args));
    }

    public String getUsage() {
        return this.getClass().getAnnotation(CommandUsage.class).value();
    }



    public String getDescription() {
        return this.getClass().getAnnotation(CommandDescription.class).value();
    }

    private static boolean hasPermission(Player player, CommandExecutor cmd) {
        CommandPermissions permissions = cmd.getClass().getAnnotation(CommandPermissions.class);
        if(permissions == null) {
            return true;
        }

        for (String permission : permissions.value()) {
            if (player.hasPermission(permission)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        // List All Commands
        if (args.length == 0) {
            return Lists.newArrayList(commandMap.keySet());
        }

        final String search = args[0].toLowerCase();

        if (args.length == 1) {
            final Set<String> matches = new HashSet<>();
            for (String name : commandMap.keySet()) {
                if (name.startsWith(search)) {
                    matches.add(name);
                }
            }
            return Lists.newArrayList(matches);
        }
        if(commandMap.containsKey(search)) {
            return null;
        }

        try {
            TabExecutor exe = (TabExecutor)commandMap.get(search);
            return exe.onTabComplete(sender, cmd, search, getSubCommandArgs(args));
        } catch (Exception ex) {
            // Command doesn't have TabCompleter
            return null;
        }

    }

    private static final String[] getSubCommandArgs(String[] oldArgs) {
        String[] cmdArgs = new String[oldArgs.length-1];
        System.arraycopy(oldArgs, 1, cmdArgs, 0, cmdArgs.length);
        return cmdArgs;
    }
}
