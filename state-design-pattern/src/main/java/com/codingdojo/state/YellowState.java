package com.codingdojo.state;

import com.codingdojo.context.TrafficLightContext;

public class YellowState implements State {

    @Override
    public String getColors () {
        return "Yellow";
    }

    @Override
    public State nextState () {
        return TrafficLightContext.RED;
    }

    @Override
    public boolean canIGo() {
        return false;
    }
}
