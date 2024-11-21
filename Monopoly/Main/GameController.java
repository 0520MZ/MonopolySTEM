package Monopoly.Main;

import Monopoly.Spaces.Space;

import java.util.*;

public class GameController {
    private static GameController instance;
    private List<Player> players;
    private Board board;
    private Dice dice;
    private int currentPlayerIndex;

    public GameController(List<String> playerNames) {
        instance = this;
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        board = new Board();
        dice = new Dice();
        currentPlayerIndex = 0;
    }

    public static GameController getInstance() {
        return instance;
    }

    public void startGame() {
        boolean gameOn = true;
        while (gameOn) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\nIt's " + currentPlayer.getName() + "'s turn.");
            takeTurn(currentPlayer);
            // Check for bankruptcy or winning conditions
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    private void takeTurn(Player player) {
        if (player.isInJail()) {
            // Handle jail logic
            System.out.println(player.getName() + " is in jail.");
            // Implement options to pay bail, use Get Out of Jail Free card, or roll doubles
        } else {
            dice.roll();
            int diceTotal = dice.getTotal();
            player.setLastDiceRoll(diceTotal);
            System.out.println(player.getName() + " rolled " + dice.getDie1() + " and " + dice.getDie2() + ".");
            player.move(diceTotal);
            System.out.println(player.getName() + " landed on " + board.getSpace(player.getPosition()).getName() + ".");
            Space currentSpace = board.getSpace(player.getPosition());
            currentSpace.landOn(player);

            // Handle doubles logic for additional turns
            if (dice.isDouble()) {
                System.out.println(player.getName() + " rolled doubles and gets another turn!");
                takeTurn(player);
            }
        }
    }

    public void payEachPlayer(Player payer, int amount) {
        for (Player player : players) {
            if (!player.equals(payer)) {
                payer.decreaseMoney(amount);
                player.increaseMoney(amount);
            }
        }
    }

    public void collectFromEachPlayer(Player collector, int amount) {
        for (Player player : players) {
            if (!player.equals(collector)) {
                player.decreaseMoney(amount);
                collector.increaseMoney(amount);
            }
        }
    }

    // Getters
    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    // No setters, as these should be managed internally
}