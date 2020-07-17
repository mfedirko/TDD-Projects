package tdd;

public class RomanNumerals {
    private int decimal = 0;
    private String numeral = "";
    public static RomanNumerals fromDecimal(int i) {
        return new RomanNumerals();
    }

    public int getDecimal() {
        return decimal;
    }

    @Override
    public String toString() {
        return numeral;
    }
}
