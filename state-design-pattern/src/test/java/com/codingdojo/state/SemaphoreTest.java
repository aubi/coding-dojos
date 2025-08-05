/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codingdojo.state;

import com.codingdojo.context.TrafficLightContext;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class SemaphoreTest {

    @Test
    public void test1Pass() {
        TrafficLightContext semaphore = new TrafficLightContext();
        assertEquals("semaphore starts with green", TrafficLightContext.GREEN, semaphore.getState());

        semaphore.changeState();
        semaphore.changeState();
        semaphore.changeState();
//        semaphore.changeState();
        assertEquals("semaphore is green after 4 changes", TrafficLightContext.GREEN, semaphore.getState());

//        assertEquals("green means GO", true, semaphore.getState().canIGo());
    }
}
