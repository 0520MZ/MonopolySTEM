package Monopoly.Cards;

import Monopoly.Main.*;

public class MoneyCard extends Card {
    private int amount;

    public MoneyCard(String description, int amount, CardType type) {
        super(description, type);
        this.amount = amount;
    }

    @Override
    public void applyEffect(Player player) {
        if (description.contains("Pay each player")) {
            // Implement logic to pay each player
            GameController.getInstance().payEachPlayer(player, amount);
        } else if (description.contains("Collect $50 from every player") || description.contains("Collect $10 from every player")) {
            // Implement logic to collect from each player
            GameController.getInstance().collectFromEachPlayer(player, amount);
        } else if (description.contains("Make general repairs") || description.contains("You are assessed for street repairs")) {
            int houseCost = description.contains("general repairs") ? 25 : 40;
            int hotelCost = description.contains("general repairs") ? 100 : 115;
            int totalHouses = player.getTotalHousesOwned();
            int totalHotels = player.getTotalHotelsOwned();
            int totalCost = (totalHouses * houseCost) + (totalHotels * hotelCost);
            player.decreaseMoney(totalCost);
            System.out.println(player.getName() + " paid $" + totalCost + " for property repairs.");
        } else {
            if (amount > 0) {
                player.increaseMoney(amount);
            } else {
                player.decreaseMoney(-amount);
            }
        }
    }

    // Getter
    public int getAmount() {
        return amount;
    }
}