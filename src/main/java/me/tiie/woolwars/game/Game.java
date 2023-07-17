package me.tiie.woolwars.game;

import java.util.List;
import java.util.UUID;

public class Game {

    private GameState state;
    // Lobby
    private int lobbyTimeRemainingSecs;
    private List<UUID> players;

    // In game
    private int roundTimeRemainingSecs;

    public GameState getState() {
        return state;
    }

    public int getLobbyTimeRemainingSecs() {
        return lobbyTimeRemainingSecs;
    }

    public int getRoundTimeRemainingSecs() {
        return roundTimeRemainingSecs;
    }

    public int getPlayerCount() {
        return players.size();
    }

    public int getLobbySpace() {
        if (state == GameState.IN_LOBBY) {
            return 6 - players.size();
        }
        return 0;
    }
}
