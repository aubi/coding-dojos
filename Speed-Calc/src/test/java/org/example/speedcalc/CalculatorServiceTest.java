package org.example.speedcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    public void testZeroIsZero () {
        CalculatorService service = new CalculatorService();
        assertEquals(0, service.calculatePaceFromKmPerHour(0), 0.001);
        assertEquals(0, service.calculateSpeedKMS(0), 0.001);
    }

    /*
    3 min/km = 20 km/h
    4 min/km = 15 km/h
    5 min/km = 12 km/h
    6 min/km = 10 km/h
     */
    @Test
    public void testPaceFromSpeed () {
        CalculatorService service = new CalculatorService();
        assertEquals(6, service.calculatePaceFromKmPerHour(10), 0.001);
    }

    @Test
    public void testSpeedFromPace () {
        CalculatorService service = new CalculatorService();
        assertEquals(10, service.calculateSpeedKMS(6), 0.001);
    }
}
