package Monopoly.Cards;

import Monopoly.Spaces.Space;

import Monopoly.Main.*;

public class MoveCard extends Card {
    private int position;
    private boolean relative;
    private boolean collect200;

    public MoveCard(String description, int position, boolean relative, boolean collect200, CardType type) {
        super(description, type);
        this.position = position;
        this.relative = relative;
        this.collect200 = collect200;
    }

    @Override
    public void applyEffect(Player player) {
        if (description.contains("nearest Monopoly.Spaces.Utility")) {
            int[] utilityPositions = {12, 28};
            int nearestUtility = findNearest(player.getPosition(), utilityPositions);
            player.setPosition(nearestUtility);
            System.out.println(player.getName() + " moves to nearest Monopoly.Spaces.Utility.");
            // Handle if unowned or pay rent
        } else if (description.contains("nearest Monopoly.Spaces.Railroad")) {
            int[] railroadPositions = {5, 15, 25, 35};
            int nearestRailroad = findNearest(player.getPosition(), railroadPositions);
            player.setPosition(nearestRailroad);
            System.out.println(player.getName() + " moves to nearest Monopoly.Spaces.Railroad.");
            // Handle paying double rent or buying
        } else if (relative) {
            player.move(position);
            System.out.println(player.getName() + " moves " + position + " spaces.");
        } else {
            if (collect200 && player.getPosition() > position) {
                player.increaseMoney(200);
                System.out.println(player.getName() + " collects $200 for passing Go.");
            }
            player.setPosition(position);
            System.out.println(player.getName() + " moves to " + position + ".");
        }
        // Handle landing on the new space
        Space currentSpace = GameController.getInstance().getBoard().getSpace(player.getPosition());
        currentSpace.landOn(player);
    }

    // Helper method
    private int findNearest(int currentPosition, int[] positions) {
        int minDistance = 40; // Maximum distance on the board
        int nearestPosition = currentPosition;
        for (int pos : positions) {
            int distance = (pos - currentPosition + 40) % 40;
            if (distance > 0 && distance < minDistance) {
                minDistance = distance;
                nearestPosition = pos;
            }
        }
        return nearestPosition;
    }

    // Getters
    public int getPosition() {
        return position;
    }

    public boolean isRelative() {
        return relative;
    }

    public boolean isCollect200() {
        return collect200;
    }
}