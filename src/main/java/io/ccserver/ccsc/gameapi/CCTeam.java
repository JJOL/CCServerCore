package io.ccserver.ccsc.gameapi;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by JJOL on 18/08/2015.
 */


public class CCTeam {

    @Getter
    private final int ID;
    private final Set<UUID>  MEMBERS = new HashSet<>();

    private static int idCounter = 0;

    public CCTeam() {
        ID = idCounter++;
    }

    public void removePlayer() {

    }

    public void addPlayer() {

    }

    public boolean isTeamDead() {
        return MEMBERS.size() == 0;
    }

}
