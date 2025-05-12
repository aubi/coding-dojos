package org.example.speedcalc;

public class CalculatorService {

    public double calculateSpeedKMS(double paceMINKM) {

        double speed = 3600 / (pace * 1000.0);
        return speed;
    }

    public double calculatePaceFromKmPerHour(double speedKMH) {

        double pace = 3600 / (speedKMH * 1000.0);
        return pace;
    }
}
