package Monopoly.Cards;

import Monopoly.Main.*;

public abstract class Card {
    protected String description;
    protected CardType type;

    public Card(String description, CardType type) {
        this.description = description;
        this.type = type;
    }

    public abstract void applyEffect(Player player);

    // Getters
    public String getDescription() {
        return description;
    }

    public CardType getType() {
        return type;
    }
}