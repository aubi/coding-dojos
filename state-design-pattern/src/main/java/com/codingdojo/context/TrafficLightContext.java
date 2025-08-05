package com.codingdojo.context;

import com.codingdojo.state.GreenState;
import com.codingdojo.state.RedState;

import com.codingdojo.state.State;
import com.codingdojo.state.YellowState;

public class TrafficLightContext {
    public static final State RED = new RedState();
    public static final State YELLOW = new YellowState();
    public static final State GREEN = new GreenState();

    public TrafficLightContext() {
        currentState = GREEN;
    }

    private State currentState;

    public State getState() {
        return currentState;
    }

    public void changeState() {
        currentState = currentState.nextState();
    }

    public void reset() {
        currentState = GREEN;
    }

    public enum TrafficColor {
        RED,
        YELLOW,
        GREEN
    }
}
