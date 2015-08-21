package io.ccserver.ccsc.gameapi;

import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * Created by JJOL on 18/08/2015.
 */
public interface PlayerGameCache {

    void saveAllData();
    void saveData(String keyName);

}
