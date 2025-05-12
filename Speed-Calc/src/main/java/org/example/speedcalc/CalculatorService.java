package org.example.speedcalc;

public class CalculatorService {

    public double calculateSpeedMS (double pace) {

        throw new UnsupportedOperationException();
    }

    public double calculatePace (double speedMS) {

        double pace = 1/speedMS;
        double minPerKm = pace * 1000;
        throw new UnsupportedOperationException();
    }
}
