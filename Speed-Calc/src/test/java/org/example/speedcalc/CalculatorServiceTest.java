package org.example.speedcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    @Test
    public void testZeroIsZero () {
        CalculatorService service = new CalculatorService();
        assertEquals(0, service.calculatePace(0), 0.001);
    }
}
