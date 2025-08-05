package com.codingdojo.context;

import com.codingdojo.state.TrafficLight;

public class TrafficLightContext implements TrafficLight {


    @Override
    public String getState() {
        return "";
    }

    @Override
    public void changeState() {

    }

    @Override
    public void reset() {

    }

    public enum TrafficColor {
        RED,
        YELLOW,
        GREEN
    }
}
