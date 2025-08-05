package com.codingdojo;

import com.codingdojo.context.TrafficLightContext;

/**
 * We will practice one of the very nice design patterns - State
 *
 * The task will be simple simulator of a Traffic light.
 * Every second, write a line in a form:
 * ---- YELLOW RED - STOP
 * GREEN ---- ---- - GO
 * The purpose of the State pattern is to simplify code and remove "if" statements. Try to use none as much as possible.
 *
 *
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to Traffic Light!");
        TrafficLightContext trafficLightContext = new TrafficLightContext();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Current Colors: " + trafficLightContext.getState().getColors());
            trafficLightContext.changeState();
            System.out.println("I can go: " + trafficLightContext.canIGo() + " in color:" + trafficLightContext.getState().getColors());
        }
    }
}