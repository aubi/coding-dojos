package com.codingdojo.context;

import com.codingdojo.state.GreenState;
import com.codingdojo.state.RedState;
import com.codingdojo.state.RedYellowState;
import com.codingdojo.state.State;
import com.codingdojo.state.TrafficLight;
import com.codingdojo.state.YellowState;

public class TrafficLightContext implements TrafficLight {
    private static final State RED = new RedState();
    private static final State YELLOW = new YellowState();
    private static final State GREEN = new GreenState();
    private static final State RED_YELLOW = new RedYellowState();
    private static final State[] SEQUENCE = new State[] {GREEN, YELLOW, RED, RED_YELLOW};
    private int index = 0;
    
    private State currentState;

    @Override
    public String getState() {
        return this.currentState.getState();
    }

    @Override
    public void changeState() {
        ++this.index;
        if (this.index >= SEQUENCE.length) {
            this.index = 0;
        }
        this.currentState = SEQUENCE[index];
    }

    @Override
    public void reset() {
        this.currentState = GREEN;
        this.index = 0;
    }

    public enum TrafficColor {
        RED,
        YELLOW,
        GREEN
    }
}
