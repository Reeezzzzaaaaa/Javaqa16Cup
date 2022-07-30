package ru.netology.javaqa.player;

public class Player {

    private final int playerId;
    private final String playerName;
    private final int playerStrength;
    private String skill;

    public Player(int playerId, String playerName, int playerStrength, String skill) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerStrength = playerStrength;
        this.skill = skill;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerStrength() {
        return playerStrength;
    }

    public String getSkill() {
        return skill;
    }
}
