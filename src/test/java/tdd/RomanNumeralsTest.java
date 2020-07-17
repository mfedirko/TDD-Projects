package tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void blankRomanIs0() {
        RomanNumerals numeral = RomanNumerals.fromDecimal(0);
        assertEquals(0,numeral.getDecimal());
        assertEquals("",numeral.toString());
    }

}