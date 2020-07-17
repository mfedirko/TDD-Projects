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

    @Test
    public void repeatedNumeral() {
        assertEquals("II", RomanNumerals.fromDecimal(2).toString());
        assertEquals("III", RomanNumerals.fromDecimal(3).toString());
        assertEquals("XX", RomanNumerals.fromDecimal(20).toString());
        assertEquals("XXX", RomanNumerals.fromDecimal(30).toString());
        assertEquals("CC", RomanNumerals.fromDecimal(200).toString());
        assertEquals("CCC", RomanNumerals.fromDecimal(300).toString());
        assertEquals("MM", RomanNumerals.fromDecimal(2000).toString());
        assertEquals("MMM", RomanNumerals.fromDecimal(3000).toString());
    }

    @Test
    public void twoNumerals_suffix() {
        assertEquals("VI", RomanNumerals.fromDecimal(6).toString());
        assertEquals("XI", RomanNumerals.fromDecimal(11).toString());
        assertEquals("XV", RomanNumerals.fromDecimal(15).toString());
        assertEquals("LI", RomanNumerals.fromDecimal(51).toString());
        assertEquals("LV", RomanNumerals.fromDecimal(55).toString());
        assertEquals("LX", RomanNumerals.fromDecimal(60).toString());
        assertEquals("CV", RomanNumerals.fromDecimal(105).toString());
        assertEquals("CX", RomanNumerals.fromDecimal(110).toString());
        assertEquals("CL", RomanNumerals.fromDecimal(150).toString());
        assertEquals("DC", RomanNumerals.fromDecimal(600).toString());
        assertEquals("MI", RomanNumerals.fromDecimal(1001).toString());
        assertEquals("MX", RomanNumerals.fromDecimal(1010).toString());
        assertEquals("MC", RomanNumerals.fromDecimal(1100).toString());
        assertEquals("MD", RomanNumerals.fromDecimal(1500).toString());
    }
}