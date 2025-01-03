package Monopoly.Spaces;

import Monopoly.Main.*;
import Monopoly.Properties.Property;
import Monopoly.Properties.PropertyGroup;

//public class Utility extends Property {
//    private int price;
//    private Player owner;
//    private boolean mortgaged;
//
//    public Utility(String name, int price) {
//        super(name);
//        this.price = price;
//        this.owner = null;
//        this.mortgaged = false;
//    }
//
//    @Override
//    public void landOn(Player player) {
//        if (owner == null) {
//            // Offer to buy the utility
//            player.offerToBuyProperty(this);
//        } else if (!owner.equals(player) && !mortgaged) {
//            // Calculate rent based on dice roll
//            int diceTotal = player.getLastDiceRoll();
//            int utilitiesOwned = owner.getUtilitiesOwned();
//            int rentMultiplier = utilitiesOwned == 1 ? 4 : 10;
//            int rentToPay = diceTotal * rentMultiplier;
//            player.payRent(rentToPay, owner);
//        }
//    }
//
//    // Getters and Setters
//    public int getPrice() {
//        return price;
//    }
//
//    public Player getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Player owner) {
//        this.owner = owner;
//    }
//
//    public boolean isMortgaged() {
//        return mortgaged;
//    }
//
//    public void setMortgaged(boolean mortgaged) {
//        this.mortgaged = mortgaged;
//    }
//}

public class Utility extends Property {
    public Utility(String name, int price) {
        super(name, price, PropertyGroup.UTILITY);
    }

    @Override
    public void landOn(Player player) {
        if (getOwner() == null) {
            // Offer to buy the utility
            player.offerToBuyProperty(this);
        } else if (!getOwner().equals(player) && !isMortgaged()) {
            // Calculate rent based on dice roll
            int diceTotal = player.getLastDiceRoll();
            int utilitiesOwned = getOwner().getUtilitiesOwned();
            int rentMultiplier = utilitiesOwned == 1 ? 4 : 10;
            int rentToPay = diceTotal * rentMultiplier;
            player.payRent(rentToPay, getOwner());
        }
    }
}