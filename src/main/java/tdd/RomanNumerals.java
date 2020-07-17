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
        if (decimal < 0 || decimal > 3999) throw new IllegalArgumentException("Only 0 - 3999 are supported!");
        this.decimal = decimal;
        createNumeral(decimal);
    }

    private void createNumeral(int decimal) {
        if (decimal > 0) {
            for (BasicNumeral numeral : BasicNumeral.ordered) {
                boolean useSubtractor = shouldUseSubtractor(decimal, numeral);

                int num = numeral.decimalValue;
                if (decimal / num > 0 || useSubtractor) {
                    if (!useSubtractor) {
                        for (int i = 0; i < decimal / num; i++) {
                            this.numeral += numeral;
                        }
                    } else {
                        BasicNumeral subtractor = numeral.subtractor;
                        decimal = decimal + subtractor.decimalValue;
                        for (int i = 0; i < (decimal / num) - 1; i++) {
                            this.numeral += numeral;
                        }
                        this.numeral += subtractor;
                        this.numeral += numeral;
                    }
                    decimal = decimal % num;
                    if (decimal == 0) break;
                }
            }
        }
    }

    private boolean shouldUseSubtractor(int decimal, BasicNumeral numeral) {
        boolean useSubtractor = false;
        BasicNumeral subtractor = numeral.subtractor;
        if (subtractor != null) {
            if ((decimal + subtractor.decimalValue) / numeral.decimalValue > decimal / numeral.decimalValue) {
                useSubtractor = true;
            }
        }
        return useSubtractor;
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
