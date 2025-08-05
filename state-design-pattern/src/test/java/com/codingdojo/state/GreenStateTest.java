package com.codingdojo.state;

import com.codingdojo.context.TrafficLightContext;
import junit.framework.TestCase;
public class GreenStateTest extends TestCase {

    GreenState greenState = new GreenState();

    public void testGreenState() {
        assertEquals(TrafficLightContext.YELLOW, greenState.nextState());
    }
}