package io.ccserver.ccsc.gameapi;

/**
 * Created by JJOL on 14/08/2015.
 */
public abstract class GameBase {

    private int maxPlayersSize;
    private int playerAmount;


    public boolean joinPlayer() {

        if (playerAmount > maxPlayersSize) {
            return false;
        }

        return true;
    }

}
