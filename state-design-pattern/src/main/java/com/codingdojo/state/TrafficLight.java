package com.codingdojo.state;

public interface TrafficLight {

    /**
     * Returns the current state of the traffic light.
     *
     * @return the current state as a string
     */
    String getState();

    /**
     * Changes the state of the traffic light to the next state.
     */
    void changeState();

    /**
     * Resets the traffic light to its initial state.
     */
    void reset();

}
