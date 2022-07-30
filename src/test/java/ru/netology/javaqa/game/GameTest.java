package ru.netology.javaqa.game;
import org.junit.jupiter.api.Assertions;
import ru.netology.javaqa.player.Player;
import ru.netology.javaqa.exception.NotRegisteredException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Slava", 100, "Мастер");
    Player player2 = new Player(2, "Petya", 10, "Новичек");
    Player player3 = new Player(3, "Dima", 70, "Средний");
    Player player4 = new Player(4, "Olya", 80, "Высокий");
    Player player5 = new Player(5, "Sveta", 70, "Средний");
    Player player6 = new Player(6, "Vika", 50, "Средний");
    Player player7 = new Player(7, "Artem", 60, "Средний");
    Player player8 = new Player(8, "Gora", 20, "Новичек");
    Player player9 = new Player(9, "Anya", 40, "Новичек");
    Player player10 = new Player(10, "Kolya", 90, "Высокий");

    @BeforeEach
    public void registered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
    }

    @Test
    public void registerTest() {

        game.register(player10);

        int expected = 10;
        int actual = game.getPlayersList().size();

        assertEquals(expected,actual);
    }

    @Test
    public void roundWinFirst() {

        int expected = 1;
        int actual = game.round(player1, player3);

        assertEquals(expected, actual);
    }

    @Test
    public void roundWinSecond() {

        int expected = 2;
        int actual = game.round(player2, player8);

        assertEquals(expected, actual);
    }

    @Test
    public void roundTied() {

        int expected = 0;
        int actual = game.round(player3, player5);

        assertEquals(expected, actual);
    }

    @Test
    public void playerName1ExceptionTest() {

        assertThrows(NotRegisteredException.class, () -> game.round(player10, player4));
    }

    @Test
    public void playerName2ExceptionTest() {

        assertThrows(NotRegisteredException.class, () -> game.round(player6, player10));
    }

    @Test
    public void mapInfoTest() {

        game.addMap(player1);
        game.addMap(player2);
        game.addMap(player3);
        game.addMap(player4);
        game.addMap(player5);
        game.addMap(player6);
        game.addMap(player7);
        game.addMap(player8);
        game.addMap(player9);
        game.addMap(player10);

        String[] expected = {"Средний"};
        String[] actual = {game.infoAboutOfPlayer(player5)};

        Assertions.assertArrayEquals(expected, actual);
    }
}
