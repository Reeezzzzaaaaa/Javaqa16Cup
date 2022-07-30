package ru.netology.javaqa.player;

public class Player {

    private final int playerId;
    private final String playerName;
    private final int playerStrength;

    public Player(int playerId, String playerName, int playerStrength) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerStrength = playerStrength;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerStrength() {
        return playerStrength;
    }
}
