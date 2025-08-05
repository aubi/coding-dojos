package com.codingdojo.state;

import com.codingdojo.context.TrafficLightContext;

public class RedState implements State {

    @Override
    public String getColors () {
        return "Red";
    }

    @Override
    public State nextState () {
        return TrafficLightContext.GREEN;
    }

    @Override
    public boolean canIGo() {
        return false;
    }
}
