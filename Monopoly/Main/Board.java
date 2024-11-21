package Monopoly.Main;

import java.util.*;

import Monopoly.Spaces.*;
import Monopoly.Cards.*;
import Monopoly.Properties.*;

public class Board {
    private List<Space> spaces;
    private Deck chanceDeck;
    private Deck communityChestDeck;

    public Board() {
        spaces = new ArrayList<>(40);
        chanceDeck = new Deck(createChanceCards());
        communityChestDeck = new Deck(createCommunityChestCards());
        initializeSpaces();
    }

    private void initializeSpaces() {
        spaces.add(new GoSpace("Go"));
        spaces.add(new Property("Mediterranean Avenue", 60, new int[]{2, 10, 30, 90, 160, 250}, 50, PropertyGroup.BROWN));
        spaces.add(new CommunityChestSpace("Community Chest", communityChestDeck));
        spaces.add(new Property("Baltic Avenue", 60, new int[]{4, 20, 60, 180, 320, 450}, 50, PropertyGroup.BROWN));
        spaces.add(new TaxSpace("Income Tax", 200));
        spaces.add(new Railroad("Reading Monopoly.Spaces.Railroad", 200));
        spaces.add(new Property("Oriental Avenue", 100, new int[]{6, 30, 90, 270, 400, 550}, 50, PropertyGroup.LIGHT_BLUE));
        spaces.add(new ChanceSpace("Chance", chanceDeck));
        spaces.add(new Property("Vermont Avenue", 100, new int[]{6, 30, 90, 270, 400, 550}, 50, PropertyGroup.LIGHT_BLUE));
        spaces.add(new Property("Connecticut Avenue", 120, new int[]{8, 40, 100, 300, 450, 600}, 50, PropertyGroup.LIGHT_BLUE));
        spaces.add(new JailSpace("Jail"));
        spaces.add(new Property("St. Charles Place", 140, new int[]{10, 50, 150, 450, 625, 750}, 100, PropertyGroup.PINK));
        spaces.add(new Utility("Electric Company", 150));
        spaces.add(new Property("States Avenue", 140, new int[]{10, 50, 150, 450, 625, 750}, 100, PropertyGroup.PINK));
        spaces.add(new Property("Virginia Avenue", 160, new int[]{12, 60, 180, 500, 700, 900}, 100, PropertyGroup.PINK));
        spaces.add(new Railroad("Pennsylvania Monopoly.Spaces.Railroad", 200));
        spaces.add(new Property("St. James Place", 180, new int[]{14, 70, 200, 550, 750, 950}, 100, PropertyGroup.ORANGE));
        spaces.add(new CommunityChestSpace("Community Chest", communityChestDeck));
        spaces.add(new Property("Tennessee Avenue", 180, new int[]{14, 70, 200, 550, 750, 950}, 100, PropertyGroup.ORANGE));
        spaces.add(new Property("New York Avenue", 200, new int[]{16, 80, 220, 600, 800, 1000}, 100, PropertyGroup.ORANGE));
        spaces.add(new FreeParkingSpace("Free Parking"));
        spaces.add(new Property("Kentucky Avenue", 220, new int[]{18, 90, 250, 700, 875, 1050}, 150, PropertyGroup.RED));
        spaces.add(new ChanceSpace("Chance", chanceDeck));
        spaces.add(new Property("Indiana Avenue", 220, new int[]{18, 90, 250, 700, 875, 1050}, 150, PropertyGroup.RED));
        spaces.add(new Property("Illinois Avenue", 240, new int[]{20, 100, 300, 750, 925, 1100}, 150, PropertyGroup.RED));
        spaces.add(new Railroad("B. & O. Monopoly.Spaces.Railroad", 200));
        spaces.add(new Property("Atlantic Avenue", 260, new int[]{22, 110, 330, 800, 975, 1150}, 150, PropertyGroup.YELLOW));
        spaces.add(new Property("Ventnor Avenue", 260, new int[]{22, 110, 330, 800, 975, 1150}, 150, PropertyGroup.YELLOW));
        spaces.add(new Utility("Water Works", 150));
        spaces.add(new Property("Marvin Gardens", 280, new int[]{24, 120, 360, 850, 1025, 1200}, 150, PropertyGroup.YELLOW));
        spaces.add(new GoToJailSpace("Go To Jail"));
        spaces.add(new Property("Pacific Avenue", 300, new int[]{26, 130, 390, 900, 1100, 1275}, 200, PropertyGroup.GREEN));
        spaces.add(new Property("North Carolina Avenue", 300, new int[]{26, 130, 390, 900, 1100, 1275}, 200, PropertyGroup.GREEN));
        spaces.add(new CommunityChestSpace("Community Chest", communityChestDeck));
        spaces.add(new Property("Pennsylvania Avenue", 320, new int[]{28, 150, 450, 1000, 1200, 1400}, 200, PropertyGroup.GREEN));
        spaces.add(new Railroad("Short Line", 200));
        spaces.add(new ChanceSpace("Chance", chanceDeck));
        spaces.add(new Property("Park Place", 350, new int[]{35, 175, 500, 1100, 1300, 1500}, 200, PropertyGroup.DARK_BLUE));
        spaces.add(new TaxSpace("Luxury Tax", 100));
        spaces.add(new Property("Boardwalk", 400, new int[]{50, 200, 600, 1400, 1700, 2000}, 200, PropertyGroup.DARK_BLUE));
    }

    public Space getSpace(int position) {
        return spaces.get(position);
    }

    // Getters and Setters
    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }

    public Deck getChanceDeck() {
        return chanceDeck;
    }

    public void setChanceDeck(Deck chanceDeck) {
        this.chanceDeck = chanceDeck;
    }

    public Deck getCommunityChestDeck() {
        return communityChestDeck;
    }

    public void setCommunityChestDeck(Deck communityChestDeck) {
        this.communityChestDeck = communityChestDeck;
    }

    private List<Card> createChanceCards() {
        List<Card> cards = new ArrayList<>();

        cards.add(new MoveCard("Advance to Go (Collect $200)", 0, false, true, CardType.CHANCE));
        cards.add(new MoveCard("Advance to Illinois Ave. If you pass Go, collect $200.", 24, false, true, CardType.CHANCE));
        cards.add(new MoveCard("Advance to St. Charles Place. If you pass Go, collect $200.", 11, false, true, CardType.CHANCE));
        cards.add(new MoveCard("Advance token to the nearest Monopoly.Spaces.Utility. If unowned, you may buy it from the Bank.", -1, true, false, CardType.CHANCE));
        cards.add(new MoveCard("Advance token to the nearest Monopoly.Spaces.Railroad. Pay owner twice the rental to which they are otherwise entitled. If Monopoly.Spaces.Railroad is unowned, you may buy it from the Bank.", -1, true, false, CardType.CHANCE));
        cards.add(new MoneyCard("Bank pays you dividend of $50.", 50, CardType.CHANCE));
        cards.add(new JailCard("Get Out of Jail Free. This card may be kept until needed or traded.", false, CardType.CHANCE));
        cards.add(new MoveCard("Go Back 3 Spaces.", -3, true, false, CardType.CHANCE));
        cards.add(new JailCard("Go to Jail. Go directly to Jail. Do not pass Go, do not collect $200.", true, CardType.CHANCE));
        cards.add(new MoneyCard("Make general repairs on all your property: For each house pay $25, for each hotel $100.", 0, CardType.CHANCE));
        cards.add(new MoneyCard("Pay poor tax of $15.", -15, CardType.CHANCE));
        cards.add(new MoveCard("Take a trip to Reading Monopoly.Spaces.Railroad. If you pass Go, collect $200.", 5, false, true, CardType.CHANCE));
        cards.add(new MoveCard("Take a walk on the Boardwalk. Advance token to Boardwalk.", 39, false, false, CardType.CHANCE));
        cards.add(new MoneyCard("You have been elected Chairman of the Monopoly.Spaces.Board. Pay each player $50.", -50, CardType.CHANCE));
        cards.add(new MoneyCard("Your building loan matures. Receive $150.", 150, CardType.CHANCE));
        cards.add(new MoneyCard("You have won a crossword competition. Collect $100.", 100, CardType.CHANCE));

        return cards;
    }

    private List<Card> createCommunityChestCards() {
        List<Card> cards = new ArrayList<>();

        cards.add(new MoneyCard("Advance to Go (Collect $200).", 200, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Bank error in your favor. Collect $200.", 200, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Doctor's fees. Pay $50.", -50, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("From sale of stock you get $50.", 50, CardType.COMMUNITY_CHEST));
        cards.add(new JailCard("Get Out of Jail Free. This card may be kept until needed or traded.", false, CardType.COMMUNITY_CHEST));
        cards.add(new JailCard("Go to Jail. Go directly to jail, do not pass Go, do not collect $200.", true, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Grand Opera Night. Collect $50 from every player for opening night seats.", 50, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Holiday Fund matures. Receive $100.", 100, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Income tax refund. Collect $20.", 20, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("It is your birthday. Collect $10 from every player.", 10, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Life insurance matures. Collect $100.", 100, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Pay hospital fees of $100.", -100, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Pay school fees of $150.", -150, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("Receive $25 consultancy fee.", 25, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.", 0, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("You have won second prize in a beauty contest. Collect $10.", 10, CardType.COMMUNITY_CHEST));
        cards.add(new MoneyCard("You inherit $100.", 100, CardType.COMMUNITY_CHEST));

        return cards;
    }
}