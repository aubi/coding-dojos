package fish.payara.romannumerals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aubi
 */
public class RomanNumeralsTest {
    /**
     * Test of convert method, of class RomanNumerals.
     */
    @Test
    public void testConvert1() {
        assertEquals("I", RomanNumerals.convert(1));
    }

    @Test
    public void testConvert1to3() {
        assertEquals("I", RomanNumerals.convert(1));
        assertEquals("II", RomanNumerals.convert(2));
        assertEquals("III", RomanNumerals.convert(3));
    }

    @Test
    public void testConvert4() {
        assertEquals("IV", RomanNumerals.convert(4));
    }

    @Test
    public void testConvert5() {
        assertEquals("V", RomanNumerals.convert(5));
    }

    @Test
    public void testConvert6to8() {
        assertEquals("VI", RomanNumerals.convert(6));
        assertEquals("VII", RomanNumerals.convert(7));
        assertEquals("VIII", RomanNumerals.convert(8));
    }
    
    @Test
    public void testConvert9() {
        assertEquals("IX", RomanNumerals.convert(9));
    }
    
    @Test
    public void testConvert10to13() {
        assertEquals("X", RomanNumerals.convert(10));
        assertEquals("XI", RomanNumerals.convert(11));
        assertEquals("XII", RomanNumerals.convert(12));
        assertEquals("XIII", RomanNumerals.convert(13));
    }
    
    @Test
    public void testConvert14() {
        assertEquals("XIV", RomanNumerals.convert(14));
    }
    
    @Test
    public void testConvert15to18() {
        assertEquals("XV", RomanNumerals.convert(15));
        assertEquals("XVI", RomanNumerals.convert(16));
        assertEquals("XVII", RomanNumerals.convert(17));
        assertEquals("XVIII", RomanNumerals.convert(18));
    }

    @Test
    public void testConvert20to23() {
        assertEquals("XX", RomanNumerals.convert(20));
        assertEquals("XXI", RomanNumerals.convert(21));
        assertEquals("XXII", RomanNumerals.convert(22));
        assertEquals("XXIII", RomanNumerals.convert(23));
    }

    @Test
    public void testConvert19() {
        assertEquals("XIX", RomanNumerals.convert(19));
    }

    @Test
    public void testConvert30() {
        assertEquals("XXX", RomanNumerals.convert(30));
    }
}
