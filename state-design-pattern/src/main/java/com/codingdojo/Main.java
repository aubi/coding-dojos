package com.codingdojo;

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
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}