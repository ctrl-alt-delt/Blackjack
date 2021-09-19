package Blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    final int DECKSIZE = 52;

    private ArrayList<Card> deck;

    public Deck()
    {
        deck = new ArrayList<>();

        initialize();
    }

    public void initialize()
    {
        deck.clear();

        for (VALUE value : VALUE.values())
        {
            for (SUIT suit : SUIT.values())
            {
                deck.add(new Card(value, suit));
            }
        }

        shuffle();
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck()
    {
        return deck;
    }

    public Card drawCard()
    {
        Card drawnCard = deck.get(deck.size() - 1);

        deck.remove(deck.size() - 1);

        return drawnCard;
    }

    public void printDeck()
    {
        for (Card card : deck)
        {
            card.printCard();
        }
    }
}