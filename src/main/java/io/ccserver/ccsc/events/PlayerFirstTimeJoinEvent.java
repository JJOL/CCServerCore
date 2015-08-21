package io.ccserver.ccsc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by JJOL on 18/08/2015.
 */
public class PlayerFirstTimeJoinEvent extends Event {

    private Player player;
    private Date joinDate;

    public PlayerFirstTimeJoinEvent(Player player) {
        this.player = player;
        joinDate = Calendar.getInstance().getTime();
    }

    public static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

     public static HandlerList getHandlerList() {
         return handlers;
     }

    public Player getNewPlayer() {
        return player;
    }

    public Date getJoinDate() {
        return joinDate;
    }
}
