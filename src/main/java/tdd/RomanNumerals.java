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
            for (BasicNumeral numeral : BasicNumeral.ordered) {
                int num = numeral.decimalValue;
                if (decimal / num > 0) {
                    for (int i = 0; i < decimal / num; i++) {
                        this.numeral += numeral;
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

    private enum BasicNumeral {
        I(1, null),
        V(5, I),
        X(10, I),
        L(50, X),
        C(100, X),
        D(500, C),
        M(1000, C);

        private final int decimalValue;
        private final BasicNumeral subtractor;
        BasicNumeral(int decimalValue, BasicNumeral subtractor) {
            this.decimalValue = decimalValue;
            this.subtractor = subtractor;
        }

        private static final BasicNumeral[] ordered;
        static {
            ordered = new BasicNumeral[]{M, D, C, L, X, V, I};
        }
    }
}
