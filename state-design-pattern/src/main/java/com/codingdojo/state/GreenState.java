package com.codingdojo.state;

import com.codingdojo.context.TrafficLightContext;

public class GreenState implements State {

    @Override
    public String getColors() {
        return "Green";
    }

    @Override
    public State nextState() {
        return TrafficLightContext.YELLOW;
    }

    @Override
    public boolean canIGo() {
        return true;
    }
}
