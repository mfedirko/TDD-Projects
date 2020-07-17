package tdd;

public class RomanNumerals {
    private int decimal = -1;
    public static RomanNumerals fromDecimal(int i) {
        return new RomanNumerals();
    }

    public int getDecimal() {
        return decimal;
    }
}
