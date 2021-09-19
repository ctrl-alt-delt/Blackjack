package Blackjack;// TODO: Fix ace caluclation. A,7,5 ended up being a 23
//       If ace is first, handvalue calculation will always treat it as 11. Need to add the rest first then do the ACE.
// TODO: player wins if busting sometimes. 3,A,9 (P) vs 4,10,8 (D)
// todo: double check payouts/money
// TODO: Implement hand splitting

// TODO: allow configurable parameters (dealer standing, blackjack payout, etc)
// TODO: determine when to reshuffle shoe
// TODO: implement card counting
// TODO: Use a multi key map for the move lookups. [playerTotal][dealerTotal] = Blackjack.MOVE

public class Engine {

    final static boolean PRINTGAME = true;

    public static Shoe  shoe;
    public static Hand  playerHand;
    public static Money playerMoney;
    public static Hand  dealerHand;
    public static int winCount;

    public static void main(String[] args) {

        final int NUMITERATIONS = 1;
        final int NUMGAMES = 1;
        final int NUMDECKS = 1;
        final int MONEY = 100;

        float totalWins = 0;
        float totalGamesPlayed = 0;
        float totalMoney = 0;
        boolean playerWins = false;

        for (int k = 0; k < NUMITERATIONS; k++)
        {
            int gamesPlayed = 0;
            winCount = 0;

            shoe = new Shoe(NUMDECKS);
            playerMoney = new Money(MONEY);
            playerHand = new Hand();
            dealerHand = new Hand();

            for (int i = 0; i < NUMGAMES; i++) {

                if (PRINTGAME)
                {
                    System.out.println("****************************");
                    System.out.println("*     GAME " + "[" + k + "|" + i + "]" + " START"  );
                    System.out.println("****************************");
                    System.out.println();
                    System.out.println("Cards in Blackjack.Shoe: " + shoe.getSize());
                    System.out.println("Player Blackjack.Money: " + playerMoney.getBalance());
                    System.out.println();
                }

                if (playerBet())
                {
                    break;
                }

                dealHands();

                playerTurn();

                dealerTurn();

                playerWins = processResults(playerHand, dealerHand);

                gamesPlayed++;

                if (PRINTGAME)
                {
                    System.out.println("****************************");
                    System.out.println("*     GAME " + "[" + k + "|" + i + "]" + " END"  );
                    System.out.println("****************************");

                    for (Card c : dealerHand.getHand())
                    {
                        System.out.println(c.getValue() + ", " + c.getSuit());
                    }
                    System.out.println(dealerHand.getHandValue());
                    System.out.println("------------------");
                    for (Card c : playerHand.getHand())
                    {
                        System.out.println(c.getValue() + ", " + c.getSuit());
                    }
                    System.out.println(playerHand.getHandValue());
                    System.out.println();

                    if (playerWins)
                    {
                        System.out.println("Player Wins!");
                    }
                    else
                    {
                        System.out.println("Dealer Wins!");
                    }
                    System.out.println();
                }
            }

            totalWins += winCount;
            totalGamesPlayed += gamesPlayed;
            totalMoney += playerMoney.getBalance();
        }

        System.out.println("****************************");
        System.out.println("*     SIMULATION COMPLETE  ");
        System.out.println("****************************");
        System.out.println();

        System.out.println("----------------");
        System.out.println("# Iterations: " + NUMITERATIONS);
        System.out.println("# Games: " + NUMGAMES);
        System.out.println("----------------");
        System.out.println();
        System.out.println("Average Games Played: " + (totalGamesPlayed / NUMITERATIONS));
        System.out.println("Average Win Percentage: " + (100 * (totalWins / totalGamesPlayed)));
        System.out.println("Average Blackjack.Money: " + (totalMoney / NUMITERATIONS));
    }

    public static boolean playerBet() {
        int bet = 10;
        boolean outOfMoney = false;

        if ((playerMoney.getBalance() - bet) > 0) {
            playerHand.setBet(bet);
            playerMoney.deductBalance(bet);
        } else {
            outOfMoney = true;
        }

        return outOfMoney;
    }

    public static void playerTurn()
    {
        MOVE move = MOVE.DFT;
        boolean firstMove = true;

        while (playerHand.getHandValue() <= 21 && (move != MOVE.STD))
        {
            if (PRINTGAME)
            {
                System.out.println(dealerHand.getHand().get(0).getValue() + ", " + dealerHand.getHand().get(0).getSuit());
                System.out.println(dealerHand.getHand().get(0).getNumericalValue());
                System.out.println("------------------");
                for (Card c : playerHand.getHand())
                {
                    System.out.println(c.getValue() + ", " + c.getSuit());
                }
                System.out.println(playerHand.getHandValue());
                System.out.println();
            }

            move = getMove(playerHand, dealerHand.getHand().get(0));

            switch (move)
            {
                case HIT:
                    playerHand.addCard(shoe.drawCard());
                    break;
                case DBL:
                    if (firstMove)
                    {
                        playerHand.setBet((playerHand.getBet() * 2));
                        playerMoney.deductBalance(playerHand.getBet());
                        playerHand.addCard(shoe.drawCard());
                        move = MOVE.STD;
                        firstMove = false;
                    }
                    else
                    {
                        playerHand.addCard(shoe.drawCard());
                    }
                    break;
                case SPL:
                    if (firstMove)
                    {
                        //System.out.println("SPLIT: Not implemented.");
                        playerHand.addCard(shoe.drawCard());
                    }
                    break;
                case STD:
                default:
                    break;
            }

            if (firstMove)
            {
                firstMove = false;
            }
        }
    }

    public static void dealerTurn()
    {
        while (dealerHand.getHandValue() < 17)
        {
            dealerHand.addCard(shoe.drawCard());
        }
    }

    public static boolean processResults(Hand playerHand, Hand dealerHand)
    {
        boolean playerWins = false;
        boolean playerBlackJack = false;

        // Check if player has blackjack
        if ((playerHand.getHand().size() == 2) && (playerHand.getHandValue() == 21))
        {
            playerBlackJack = true;
        }

        // See if we won
        if (dealerHand.getHandValue() > 21)
        {
            playerWins = true;
        }
        else if (playerHand.getHandValue() > 21)
        {
            playerWins = false;
        }
        else if (playerHand.getHandValue() > dealerHand.getHandValue())
        {
            playerWins = true;
        }
        else if (dealerHand.getHandValue() == playerHand.getHandValue())
        {
            playerMoney.increaseBalance(playerHand.getBet());
        }

        if (playerWins)
        {
            if (playerBlackJack)
            {
                playerMoney.increaseBalance((int) (2.5 * playerHand.getBet()));
            }
            else
            {
                playerMoney.increaseBalance(2 * playerHand.getBet());
            }

            winCount++;
        }

        return playerWins;
    }

    public static void dealHands()
    {
        if (shoe.getSize() < 15)
        {
            shoe.initializeShoe(1);
        }

        playerHand.clearHand();
        for (int i = 0; i < playerHand.getInitialHandSize(); i++)
        {
            playerHand.addCard(shoe.drawCard());
        }

        dealerHand.clearHand();
        for (int i = 0; i < dealerHand.getInitialHandSize(); i++)
        {
            dealerHand.addCard(shoe.drawCard());
        }
    }

    public static MOVE getMove(Hand playerHand, Card dealerUpCard)
    {
        MOVE playerMove = MOVE.DFT;
        int playerIndex = 0;
        int dealerIndex = 0;
        int handValue = 0;
        boolean doSplit = false;

        dealerIndex =
            switch (dealerUpCard.getValue())
            {
                case TWO -> 0;
                case THREE -> 1;
                case FOUR -> 2;
                case FIVE -> 3;
                case SIX -> 4;
                case SEVEN -> 5;
                case EIGHT -> 6;
                case NINE -> 7;
                case TEN, JACK, QUEEN, KING -> 8;
                case ACE -> 9;
            };

        handValue = playerHand.getHandValue();

        if (playerHand.isPair())
        {
            playerIndex =
                switch (handValue)
                {
                    case 4 -> 0;
                    case 6 -> 1;
                    case 8 -> 2;
                    case 10 -> 3;
                    case 12 -> 4;
                    case 14 -> 5;
                    case 16 -> 6;
                    case 18 -> 7;
                    case 20 -> 8;
                    case 13 -> 9;

                    default -> throw new IllegalStateException("Unexpected value: " + handValue);
                };

            doSplit = StrategyTables.getInstance().getPairTotalTable()[playerIndex][dealerIndex];

            if (doSplit)
            {
                playerMove = MOVE.SPL;
            }
            else
            {
                playerMove = StrategyTables.getInstance().getHardTotalTable()[playerIndex][dealerIndex];
            }

            if (PRINTGAME)
            {
                System.out.println("Table: Pair Table");
            }

        }
        else if (playerHand.containsAce())
        {
            playerIndex =
                switch (handValue)
                    {
                        case 12,13 -> 0;
                        case 14 -> 1;
                        case 15 -> 2;
                        case 16 -> 3;
                        case 17 -> 4;
                        case 18 -> 5;
                        case 19 -> 6;
                        case 20, 21 -> 7;

                        default -> throw new IllegalStateException("Unexpected value: " + handValue);
                    };

            playerMove = StrategyTables.getInstance().getSoftTotalTable()[playerIndex][dealerIndex];

            if (PRINTGAME)
            {
                System.out.println("Table: Soft Table");
            }
        }
        else
        {
            playerIndex =
                switch (handValue)
                {
                    case 2,3,4,5,6,7,8 -> 0;
                    case 9 -> 1;
                    case 10 -> 2;
                    case 11 -> 3;
                    case 12 -> 4;
                    case 13 -> 5;
                    case 14 -> 6;
                    case 15 -> 7;
                    case 16 -> 8;
                    case 17,18,19,20,21 -> 9;
                    default -> playerIndex;
                };

            playerMove = StrategyTables.getInstance().getHardTotalTable()[playerIndex][dealerIndex];

            if (PRINTGAME)
            {
                System.out.println("Table: Hard Table");
            }
        }

        if (PRINTGAME)
        {
            System.out.println("Move: " + playerMove + "[" + playerIndex + ", " + dealerIndex + "]");
            System.out.println();
        }

        return playerMove;
    }
}