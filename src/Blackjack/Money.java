package Blackjack;

public class Money {

    private int balance;

    public Money(int balance)
    {
        this.balance = balance;
    }

    public int getBalance()
    {
        return balance;
    }

    public void deductBalance(int value)
    {
        balance -= value;
    }

    public void increaseBalance(int value)
    {
        balance += value;
    }
}
