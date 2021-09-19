package Blackjack;

public class Card {

    private VALUE value;
    private SUIT suit;
    private int numericalValue;

    public Card (VALUE value, SUIT suit)
    {
        this.value = value;
        this.suit = suit;
        this.numericalValue = computeNumericalValue();
    }

    public VALUE getValue()
    {
        return value;
    }

    public SUIT getSuit()
    {
        return suit;
    }

    public void printCard()
    {
        System.out.print("[ " + value + " | " + suit + " ] ");
    }

    public int getNumericalValue()
    {
        return numericalValue;
    }

    public int computeNumericalValue()
    {
        // TODO: this code blows, redo it
        switch (value) {
            case TWO:
                numericalValue = 2;
                break;
            case THREE:
                numericalValue = 3;
                break;
            case FOUR:
                numericalValue = 4;
                break;
            case FIVE:
                numericalValue = 5;
                break;
            case SIX:
                numericalValue = 6;
                break;
            case SEVEN:
                numericalValue = 7;
                break;
            case EIGHT:
                numericalValue = 8;
                break;
            case NINE:
                numericalValue = 9;
                break;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                numericalValue = 10;
                break;
            default:
                break;
        }

        return numericalValue;
    }
}
