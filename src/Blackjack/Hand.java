package Blackjack;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;
    private int initialHandSize;
    private int handValue;
    private boolean softTotal;
    private int bet;

    public Hand()
    {
        this.hand = new ArrayList<>();
        this.handValue = 0;
        this.bet = 0;
        this.initialHandSize = 2;
    }

    public void setBet(int bet)
    {
        this.bet = bet;
    }

    public int getBet()
    {
        return bet;
    }

    public int getInitialHandSize()
    {
        return initialHandSize;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public int getHandValue()
    {
        return handValue;
    }

    public void addCard(Card card)
    {
        hand.add(card);
        computeHandValue();
    }

    public void removeCard (int index)
    {
        hand.remove(index);
    }

    public void clearHand()
    {
        hand.clear();
    }

    public boolean containsAce()
    {
        boolean isAce = false;

        for (Card card : hand)
        {
            if (card.getValue() == VALUE.ACE)
            {
                isAce = true;
                break;
            }
        }

        return isAce;
    }

    public boolean isPair()
    {
        boolean isPair = false;

        if (hand.size() == 2)
        {
            if (hand.get(0).getNumericalValue() == hand.get(1).getNumericalValue())
            {
                isPair = true;
            }
        }

        return isPair;
    }

    public void computeHandValue()
    {
        handValue = 0;

        for (Card card : hand)
        {
            if (card.getValue() == VALUE.ACE)
            {
                if ((handValue + 11) > 21)
                {
                    handValue += 1;
                }
                else
                {
                    handValue += 11;
                }
            }
            else
            {
                handValue += card.computeNumericalValue();
            }
        }
    }
}