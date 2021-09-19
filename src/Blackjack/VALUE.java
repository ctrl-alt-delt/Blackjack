package Blackjack;

enum VALUE {
    ACE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");

    private String value;

    VALUE(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static VALUE[] items = new VALUE[]{
            ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    };
}
