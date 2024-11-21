//I am testing Github

import java.util.ArrayList;
import java.util.Scanner;

public class Monopoly {

    // Player class to hold player information
    static class Player {
        String name;
        int money;
        int position;

        public Player(String name) {
            this.name = name;
            this.money = 1500; // Starting money
            this.position = 0; // Starting position on the board
        }

        public void move(int spaces) {
            this.position = (this.position + spaces) % 40; // Board has 40 spaces
        }

        public void pay(int amount) {
            this.money -= amount;
        }

        public void receive(int amount) {
            this.money += amount;
        }
    }

    // Property class to represent properties on the board
    static class Property {
        String name;
        int cost;
        int rent;
        int testVar;

        public Property(String name, int cost, int rent) {
            this.name = name;
            this.cost = cost;
            this.rent = rent;
        }

        public void landOn(Player player) {
            if (player.money >= rent) {
                player.pay(rent);
                System.out.println(player.name + " paid rent of " + rent + " for " + name);
            } else {
                System.out.println(player.name + " cannot afford the rent for " + name);
            }
        }
    }

    // Game class to manage the overall game
    static class Game {
        ArrayList<Player> players;
        ArrayList<Property> board;
        int currentPlayerIndex;
        Scanner scanner;

        public Game() {
            players = new ArrayList<>();
            board = new ArrayList<>();
            currentPlayerIndex = 0;
            scanner = new Scanner(System.in);
            setupBoard();
        }

        // Setup the board with properties
        private void setupBoard() {
            board.add(new Property("Start", 0, 0));
            board.add(new Property("Baltic Avenue", 60, 2));
            board.add(new Property("Mediterranean Avenue", 60, 4));
            // Add more properties as needed
        }

        // Add a player to the game
        public void addPlayer(String name) {
            players.add(new Player(name));
        }

        // Start the game loop
        public void start() {
            while (true) {
                Player currentPlayer = players.get(currentPlayerIndex);
                System.out.println("\n" + currentPlayer.name + "'s turn!");
                System.out.println("You have " + currentPlayer.money + " money.");

                // Roll the dice
                System.out.print("Roll the dice (press enter): ");
                scanner.nextLine();  // Simulate dice roll
                int diceRoll = (int) (Math.random() * 6) + 1;
                System.out.println(currentPlayer.name + " rolled a " + diceRoll);

                // Move the player
                currentPlayer.move(diceRoll);
                System.out.println(currentPlayer.name + " moved to " + board.get(currentPlayer.position).name);

                // Check if the player landed on a property
                Property landedProperty = board.get(currentPlayer.position);
                landedProperty.landOn(currentPlayer);

                // Next player's turn
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();

                System.out.println("test");
            }
        }
    }

    // Main function to start the game
    public static void main(String[] args) {
        Game monopolyGame = new Game();

        // Add players
        monopolyGame.addPlayer("Alice");
        monopolyGame.addPlayer("Bob");

        // Start the game
        monopolyGame.start();
    }
}
