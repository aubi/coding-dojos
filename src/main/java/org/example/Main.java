package org.example;


import java.util.Arrays;

/**
 *  String with numbers seperated by commas
 *  extract
 *  work out stats
 */
public class Main {
    public static void main(String[] args) {
        String numbersToExtract = "12,1,4,52,7,8";

        String[] array = numbersToExtract.split(",");
        System.out.println(Arrays.toString(array));
    }
}