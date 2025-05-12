package org.example.speedcalc;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class CalculatorBean implements Serializable {

    public double getPace() {
        return pace;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    private double pace;
    private double speed;

    @Inject
    CalculatorService calculator;

    public void calcPace(){
        pace = calculator.calculatePaceFromKmPerHour(speed);
    }

    public void calcSpeed(){
        speed = calculator.calculateSpeedKMS(pace);
    }


}
