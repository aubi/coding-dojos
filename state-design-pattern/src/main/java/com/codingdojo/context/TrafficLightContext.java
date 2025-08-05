package com.codingdojo.context;

import com.codingdojo.state.GreenState;
import com.codingdojo.state.RedState;
import com.codingdojo.state.RedYellowState;
import com.codingdojo.state.State;
import com.codingdojo.state.TrafficLight;
import com.codingdojo.state.YellowState;

public class TrafficLightContext implements TrafficLight {
    public static final State RED = new RedState();
    public static final State YELLOW = new YellowState();
    public static final State GREEN = new GreenState();
    public static final State RED_YELLOW = new RedYellowState();
    
    private State currentState;

    public State getState() {
        return currentState;
    }

    @Override
    public void changeState() {
        currentState = currentState.nextState();
    }

    @Override
    public void reset() {
        currentState = GREEN;
    }

    public enum TrafficColor {
        RED,
        YELLOW,
        GREEN
    }
}
