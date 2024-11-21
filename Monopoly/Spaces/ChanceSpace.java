package Monopoly.Spaces;

import Monopoly.Main.*;
import Monopoly.Cards.*;

public class ChanceSpace extends Space {
    private Deck chanceDeck;

    public ChanceSpace(String name, Deck chanceDeck) {
        super(name);
        this.chanceDeck = chanceDeck;
    }

    @Override
    public void landOn(Player player) {
        Card card = chanceDeck.drawCard();
        card.applyEffect(player);
    }

    // Getter and Setter
    public Deck getChanceDeck() {
        return chanceDeck;
    }

    public void setChanceDeck(Deck chanceDeck) {
        this.chanceDeck = chanceDeck;
    }
}