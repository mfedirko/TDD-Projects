package tdd;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {
    private static final Map<Integer, String> BASIC_NUMERALS;
    static {
        BASIC_NUMERALS = new HashMap<>();
        BASIC_NUMERALS.put(1000, "M");
        BASIC_NUMERALS.put(500, "D");
        BASIC_NUMERALS.put(100, "C");
        BASIC_NUMERALS.put(50, "L");
        BASIC_NUMERALS.put(10, "X");
        BASIC_NUMERALS.put(5, "V");
        BASIC_NUMERALS.put(1, "I");
    }
    private int decimal;
    private String numeral = "";
    public static RomanNumerals fromDecimal(int i) {
        return new RomanNumerals(i);
    }
    private RomanNumerals(int decimal) {
        this.decimal = decimal;
        if (decimal > 0) {
            numeral = BASIC_NUMERALS.get(decimal);
        }
    }

    public int getDecimal() {
        return decimal;
    }

    @Override
    public String toString() {
        return numeral;
    }
}
