package org.example.speedcalc;

public class CalculatorService {

    public double calculateSpeedKMS(double paceMINKM) {
        if (paceMINKM == 0) {
            return 0;
        }

        double speed = 60 / paceMINKM;
        return speed;
    }

    public double calculatePaceFromKmPerHour(double speedKMH) {
        if (speedKMH == 0) {
            return 0;
        }

        double pace = 60 / speedKMH;
        return pace;
    }
}
