package tdd;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Rules of Roman Numerals:
        Numerals must be arranged in descending order of size.
        M, C, and X cannot be equalled or exceeded by smaller denominations.
        D, L, and V can each only appear once.
 *  "Subtractive pairs rules"
        Only one I, X, and C can be used as the leading numeral in part of a subtractive pair.
        I can only be placed before V and X.
        X can only be placed before L and C.
        C can only be placed before D and M.
 */
public class RomanNumerals {
    private static final Map<Integer, String> BASIC_NUMERALS;
    static {
        BASIC_NUMERALS = new LinkedHashMap<>();
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
        createNumeral(decimal);
    }

    private void createNumeral(int decimal) {
        if (decimal > 0) {
            for (int num : BASIC_NUMERALS.keySet()) {
                if (decimal / num > 0) {
                    for (int i = 0; i < decimal / num; i++) {
                        numeral += BASIC_NUMERALS.get(num);
                    }
                    decimal = decimal % num;
                    if (decimal == 0) break;
                }
            }
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
