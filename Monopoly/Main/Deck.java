package Monopoly.Main;

import Monopoly.Cards.*;

import java.util.*;

public class Deck {
    private Queue<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = new LinkedList<>(cards);
        Collections.shuffle((LinkedList<Card>) this.cards);
    }

    public Card drawCard() {
        Card card = cards.poll();
        cards.offer(card); // Place card at the bottom
        System.out.println("Drew card: " + card.getDescription());
        return card;
    }

    // Getter
    public Queue<Card> getCards() {
        return cards;
    }
}