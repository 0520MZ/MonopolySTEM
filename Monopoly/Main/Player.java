package Monopoly.Main;
//test  3
import Monopoly.Properties.*;
import Monopoly.Spaces.Railroad;
import Monopoly.Spaces.Utility;

import java.util.*;

public class Player {
    private String name;
    private int position;
    private int money;
    private List<Property> properties;
    private boolean inJail;
    private int jailTurns;
    private int lastDiceRoll;
    private int getOutOfJailFreeCards;

    public Player(String name) {
        this.name = name;
        this.position = 0; // Start at 'Go'
        this.money = 1500;
        this.properties = new ArrayList<>();
        this.inJail = false;
        this.jailTurns = 0;
        this.lastDiceRoll = 0;
        this.getOutOfJailFreeCards = 0;
    }

    public void move(int steps) {
        position = (position + steps) % 40; // Assuming 40 spaces
    }

    public void setPosition(int position) {
        this.position = position % 40;
    }

    public void buyProperty(Property property) {
        if (money >= property.getPrice()) {
            money -= property.getPrice();
            property.setOwner(this);
            properties.add(property);
            System.out.println(name + " bought " + property.getName());
        } else {
            System.out.println(name + " does not have enough money to buy " + property.getName());
        }
    }

    public void payRent(int amount, Player owner) {
        if (money >= amount) {
            money -= amount;
            owner.receivePayment(amount);
            System.out.println(name + " paid $" + amount + " rent to " + owner.getName());
        } else {
            // Handle bankruptcy
            System.out.println(name + " cannot pay rent and is bankrupt!");
        }
    }

    public void receivePayment(int amount) {
        money += amount;
        System.out.println(name + " received $" + amount);
    }

    public void decreaseMoney(int amount) {
        money -= amount;
        System.out.println(name + " paid $" + amount);
        if (money < 0) {
            // Handle bankruptcy
            System.out.println(name + " is bankrupt!");
        }
    }

    public void increaseMoney(int amount) {
        money += amount;
        System.out.println(name + " received $" + amount);
    }

    public void goToJail() {
        inJail = true;
        position = 10; // Jail position
        jailTurns = 0;
        System.out.println(name + " has been sent to Jail!");
    }

    public int getRailroadsOwned() {
        int count = 0;
        for (Property prop : properties) {
            if (prop instanceof Railroad) {
                count++;
            }
        }
        return count;
    }

    public int getUtilitiesOwned() {
        int count = 0;
        for (Property prop : properties) {
            if (prop instanceof Utility) {
                count++;
            }
        }
        return count;
    }

    public void setLastDiceRoll(int total) {
        this.lastDiceRoll = total;
    }

    public int getLastDiceRoll() {
        return lastDiceRoll;
    }

    public void addGetOutOfJailFreeCard() {
        getOutOfJailFreeCards++;
        System.out.println(name + " received a Get Out of Jail Free card.");
    }

    public void useGetOutOfJailFreeCard() {
        if (getOutOfJailFreeCards > 0) {
            getOutOfJailFreeCards--;
            inJail = false;
            System.out.println(name + " used a Get Out of Jail Free card.");
        } else {
            System.out.println(name + " does not have a Get Out of Jail Free card.");
        }
    }

    public void offerToBuyProperty(Property property) {
        // Simple logic to automatically buy if player has enough money
        buyProperty(property);
    }

    // Methods to calculate total houses and hotels
    public int getTotalHousesOwned() {
        int totalHouses = 0;
        for (Property prop : properties) {
            if (prop.getHouses() < 5) {
                totalHouses += prop.getHouses();
            }
        }
        return totalHouses;
    }

    public int getTotalHotelsOwned() {
        int totalHotels = 0;
        for (Property prop : properties) {
            if (prop.getHouses() == 5) { // 5 houses represent a hotel
                totalHotels += 1;
            }
        }
        return totalHotels;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getMoney() {
        return money;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getJailTurns() {
        return jailTurns;
    }

    public void setJailTurns(int jailTurns) {
        this.jailTurns = jailTurns;
    }

    public int getGetOutOfJailFreeCards() {
        return getOutOfJailFreeCards;
    }

    public void setGetOutOfJailFreeCards(int getOutOfJailFreeCards) {
        this.getOutOfJailFreeCards = getOutOfJailFreeCards;
    }
}