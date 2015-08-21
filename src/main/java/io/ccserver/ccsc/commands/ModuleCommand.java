package io.ccserver.ccsc.commands;

/**
 * Created by JJOL on 18/08/2015.
 */
public interface ModuleCommand {

    String[] getUsage();
    boolean canBeUsed();

}
