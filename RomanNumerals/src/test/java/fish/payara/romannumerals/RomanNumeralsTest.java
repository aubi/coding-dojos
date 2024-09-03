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

}
