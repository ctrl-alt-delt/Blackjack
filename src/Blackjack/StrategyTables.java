package Blackjack;

public class StrategyTables {

    private static MOVE[][] hardTotalTable = new MOVE[][]
    {
        //                                                                                             Dealers Blackjack.Card Up
        /*   Your Blackjack.Hand           2                3                4                5                6                7                8                9               10                A   */
        /*<=8*/    /*0*/ {MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*9*/      /*1*/ {MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*10*/     /*2*/ {MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT},
        /*11*/     /*3*/ {MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL},
        /*12*/     /*4*/ {MOVE.HIT, MOVE.HIT, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*13*/     /*5*/ {MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*14*/     /*6*/ {MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*15*/     /*7*/ {MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*16*/     /*8*/ {MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*17+*/    /*9*/ {MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD},
        /*A2*/     /*10*/{MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*A3*/     /*11*/{MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*A4*/     /*12*/{MOVE.HIT, MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*A5*/     /*13*/{MOVE.HIT, MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*A6*/     /*14*/{MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*A7*/     /*15*/{MOVE.STD, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.STD, MOVE.STD, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*A8*/     /*16*/{MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD},
        /*A9*/     /*17*/{MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD},
        /*2-2*/	   /*18*/{MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*3-3*/	   /*19*/{MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*4-4*/	   /*20*/{MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.SPL, MOVE.SPL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*5-5*/	   /*21*/{MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT},
        /*6-6*/	   /*22*/{MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*7-7*/	   /*23*/{MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*8-8*/	   /*24*/{MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL},
        /*9-9*/	   /*25*/{MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.STD, MOVE.SPL, MOVE.SPL, MOVE.STD, MOVE.STD},
        /*10-10*/  /*26*/{MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD},
        /*A-A*/	   /*27*/{MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL, MOVE.SPL}
    };

    private static boolean[][] pairTotalTable = new boolean[][]
    {
        //                                  Dealers Blackjack.Card Up
        /*   Your Blackjack.Hand     2      3      4      5      6      7      8      9     10      A   */
        /*4*/     /*0*/ {true,  true,  true,  true,  true,  true,  false, false, false, false},
        /*6*/     /*0*/ {true,  true,  true,  true,  true,  true,  false, false, false, false},
        /*8*/     /*0*/ {false, false, false, true,  true,  false, false, false, false, false},
        /*10*/    /*0*/ {false, false, false, false, false, false, false, false, false, false},
        /*12*/    /*0*/ {true,  true,  true,  true,  true,  false, false, false, false, false},
        /*14*/    /*0*/ {true,  true,  true,  true,  true,  true,  false, false, false, false},
        /*16*/    /*0*/ {true,  true,  true,  true,  true,  true,  true,  true,  true,  true},
        /*18*/    /*0*/ {true,  true,  true,  true,  true,  false, true,  true,  false, false},
        /*20*/    /*0*/ {false, false, false, false, false, false, false, false, false, false},
        /*2*/     /*0*/ {true,  true,  true,  true,  true,  true,  true,  true,  true,  true}
    };

    private static MOVE[][] softTotalTable = new MOVE[][]
    {
        //                                                                                             Dealers Blackjack.Card Up
        /*   Your Blackjack.Hand           2                3                4                5                6                7                8                9               10                A   */
        /*13*/     /*0*/ {MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*14*/     /*1*/ {MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*15*/     /*2*/ {MOVE.HIT, MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*16*/     /*3*/ {MOVE.HIT, MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*17*/     /*4*/ {MOVE.HIT, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*18*/     /*5*/ {MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.DBL, MOVE.STD, MOVE.STD, MOVE.HIT, MOVE.HIT, MOVE.HIT},
        /*19*/     /*6*/ {MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.DBL, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD},
        /*20*/     /*7*/ {MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD, MOVE.STD},
    };

    private static StrategyTables INSTANCE;

    private StrategyTables()
    {
        /* Empty Constructor */
    }

    public MOVE[][] getHardTotalTable()
    {
        return hardTotalTable;
    }

    public MOVE[][] getSoftTotalTable()
    {
        return softTotalTable;
    }

    public boolean[][] getPairTotalTable()
    {
        return pairTotalTable;
    }

    public static StrategyTables getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new StrategyTables();
        }

        return INSTANCE;
    }
}
