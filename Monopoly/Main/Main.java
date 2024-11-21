package Monopoly.Main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> playerNames = Arrays.asList("Alice", "Bob", "Charlie");
        GameController gameController = new GameController(playerNames);
        gameController.startGame();
    }
}