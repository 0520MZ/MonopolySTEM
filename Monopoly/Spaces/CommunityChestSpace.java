package Monopoly.Spaces;

import Monopoly.Main.*;
import Monopoly.Cards.*;

public class CommunityChestSpace extends Space {
    private Deck communityChestDeck;

    public CommunityChestSpace(String name, Deck communityChestDeck) {
        super(name);
        this.communityChestDeck = communityChestDeck;
    }

    @Override
    public void landOn(Player player) {
        Card card = communityChestDeck.drawCard();
        card.applyEffect(player);
    }

    // Getter and Setter
    public Deck getCommunityChestDeck() {
        return communityChestDeck;
    }

    public void setCommunityChestDeck(Deck communityChestDeck) {
        this.communityChestDeck = communityChestDeck;
    }
}