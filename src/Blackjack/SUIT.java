package Blackjack;

enum SUIT {
    CLUBS("♣"), DIAMONDS("♦"), HEARTS("♥"), SPADES("♠");

    private String value;

    SUIT(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SUIT[] items = new SUIT[]{
            CLUBS, DIAMONDS, HEARTS, SPADES
    };
}
