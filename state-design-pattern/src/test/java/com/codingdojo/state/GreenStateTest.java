package com.codingdojo.state;

import junit.framework.TestCase;
public class GreenStateTest extends TestCase {

    GreenState greenState = new GreenState();

    public void testGreenState() {
        assertEquals("Green", greenState.getState());
    }
}