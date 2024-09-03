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

}
