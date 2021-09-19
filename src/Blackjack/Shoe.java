package Blackjack;

import java.util.ArrayList;

public class Shoe extends Deck {

    private ArrayList<Card> shoe;
    private int numDecks;

    public Shoe(int numDecks)
    {
        shoe = new ArrayList<>();

        initializeShoe(numDecks);
    }

    public int getSize()
    {
        return shoe.size();
    }

    public void initializeShoe(int numDecks)
    {
        shoe.clear();

        Deck deck;
        for (int i = 0; i < numDecks; i++)
        {
            deck = new Deck();
            deck.initialize();

            shoe.addAll(deck.getDeck());
        }
    }

    public Card drawCard()
    {
        Card drawnCard = shoe.get((shoe.size() - 1));

        shoe.remove(shoe.size() - 1);

        return drawnCard;
    }
}
