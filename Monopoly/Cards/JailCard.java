package Monopoly.Cards;

import Monopoly.Main.*;

public class JailCard extends Card {
    private boolean goToJail;

    public JailCard(String description, boolean goToJail, CardType type) {
        super(description, type);
        this.goToJail = goToJail;
    }

    @Override
    public void applyEffect(Player player) {
        if (goToJail) {
            player.goToJail();
        } else {
            player.addGetOutOfJailFreeCard();
        }
    }

    // Getter
    public boolean isGoToJail() {
        return goToJail;
    }
}