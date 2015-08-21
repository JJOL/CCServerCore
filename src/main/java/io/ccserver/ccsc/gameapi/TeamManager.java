package io.ccserver.ccsc.gameapi;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by JJOL on 18/08/2015.
 */
public class TeamManager {


    private final Map<String, CCTeam> TEAM_MAP = new HashMap<>();
    private final Map<UUID, String> PLAYERTEAM_MAP = new HashMap<>();

    private final String DEFAULT_TEAM;

    public TeamManager(String defaultTeam) {
        DEFAULT_TEAM = defaultTeam;

    }

    public void joinPlayerToDefault(Player player) {
        PLAYERTEAM_MAP.put(player.getUniqueId(), DEFAULT_TEAM);
    }

    public CCTeam getPlayerTeam(Player player) {
        return TEAM_MAP.get(PLAYERTEAM_MAP.get(player.getUniqueId()));
    }

}
