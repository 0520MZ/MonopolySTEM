package Monopoly.Spaces;

import Monopoly.Main.*;
import Monopoly.Properties.*;

//public class Railroad extends Property {
//    private int price;
//    private Player owner;
//    private boolean mortgaged;
//
//    public Railroad(String name, int price) {
//        super(name);
//        this.price = price;
//        this.owner = null;
//        this.mortgaged = false;
//    }
//
//    @Override
//    public void landOn(Player player) {
//        if (owner == null) {
//            // Offer to buy the railroad
//            player.offerToBuyProperty(this);
//        } else if (!owner.equals(player) && !mortgaged) {
//            // Calculate rent based on number of railroads owned
//            int railroadsOwned = owner.getRailroadsOwned();
//            int rentToPay = 25 * (int) Math.pow(2, railroadsOwned - 1);
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

public class Railroad extends Property {
    public Railroad(String name, int price) {
        super(name, price, PropertyGroup.RAILROAD);
    }

    @Override
    public void landOn(Player player) {
        if (getOwner() == null) {
            // Offer to buy the railroad
            player.offerToBuyProperty(this);
        } else if (!getOwner().equals(player) && !isMortgaged()) {
            // Calculate rent based on number of railroads owned
            int railroadsOwned = getOwner().getRailroadsOwned();
            int rentToPay = 25 * (int) Math.pow(2, railroadsOwned - 1);
            player.payRent(rentToPay, getOwner());
        }
    }
}