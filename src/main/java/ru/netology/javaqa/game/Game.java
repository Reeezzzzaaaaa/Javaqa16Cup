package ru.netology.javaqa.game;
import ru.netology.javaqa.player.Player;
import ru.netology.javaqa.exception.NotRegisteredException;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private final ArrayList<Player> playersList = new ArrayList<>();
    private HashMap<String, String> map = new HashMap<>();

    public Game() {
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public void register(Player player) {

        playersList.add(player);
    }

    public int round(Player playerName1, Player playerName2) {

        Player p1 = null;
        Player p2 = null;
        for (Player player : playersList) {
            if (matchesPlayerName(player, playerName1.getPlayerName())) {
                p1 = player;
            }
            if (matchesPlayerName(player, playerName2.getPlayerName())) {
                p2 = player;
            }

        }
        if ( p1 == null ) {
            throw new NotRegisteredException("Игрок " + playerName1 + "не зарегистрирован");
        }
        if ( p2 == null ) {
            throw new NotRegisteredException("Игрок " + playerName2 + "не зарегистрирован");
        }
        if ( p1.getPlayerStrength() == p2.getPlayerStrength() ) {
            return 0;
        }
        if ( p1.getPlayerStrength() < p2.getPlayerStrength() ) {
            return 2;
        } else {
            return 1;
        }
    }

    public boolean matchesPlayerName(Player player, String search) {
        if ( player.getPlayerName().contains(search) ) {
            return true;
        } else {
            return false;
        }
    }

    public void addMap(Player player) {
        map.put(player.getPlayerName(), player.getSkill());
    }

    public String infoAboutOfPlayer(Player player) {

        String info = null;
        for (String playerName : map.keySet()) {
            info = map.get(player.getPlayerName());
        }
        return info;
    }
}