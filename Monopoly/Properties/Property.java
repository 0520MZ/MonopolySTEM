package Monopoly.Properties;

import Monopoly.Main.*;
import Monopoly.Spaces.*;

public class Property extends Space {
    private int price;
    private int[] rent;
    private int houseCost;
    private PropertyGroup group;
    private Player owner;
    private int houses; // Number of houses (0-4), 5 represents a hotel
    private boolean mortgaged;
    private boolean isUtilityOrRailroad;

    public Property(String name, int price, int[] rent, int houseCost, PropertyGroup group) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.houseCost = houseCost;
        this.group = group;
        this.owner = null;
        this.houses = 0;
        this.mortgaged = false;
        this.isUtilityOrRailroad = false;
    }

    public Property(String name, int price, PropertyGroup group) {
        super(name);
        this.price = price;
        this.group = group;
        this.owner = null;
        this.mortgaged = false;
        this.isUtilityOrRailroad = true;
    }

    @Override
    public void landOn(Player player) {
        if (owner == null) {
            // Offer to buy the property
            player.offerToBuyProperty(this);
        } else if (!owner.equals(player) && !mortgaged) {
            // Calculate rent based on houses/hotels
            int rentToPay = rent[houses];
            player.payRent(rentToPay, owner);
        }
        // Additional logic for mortgaged properties
    }

    // Getters and Setters
    public int getPrice() {
        return price;
    }

    public int[] getRent() {
        return rent;
    }

    public int getHouseCost() {
        return houseCost;
    }

    public PropertyGroup getGroup() {
        return group;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }
}