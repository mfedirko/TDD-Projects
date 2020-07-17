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
    @Test
    public void singleNumerals() {
        assertEquals("I", RomanNumerals.fromDecimal(1).toString());
        assertEquals("V", RomanNumerals.fromDecimal(5).toString());
        assertEquals("X", RomanNumerals.fromDecimal(10).toString());
        assertEquals("L", RomanNumerals.fromDecimal(50).toString());
        assertEquals("C", RomanNumerals.fromDecimal(100).toString());
        assertEquals("D", RomanNumerals.fromDecimal(500).toString());
        assertEquals("M", RomanNumerals.fromDecimal(1000).toString());
    }
}