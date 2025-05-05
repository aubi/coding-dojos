package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 *  String with numbers seperated by commas
 *  extract
 *  work out stats
 */
public class Main {
    public static void main(String[] args) {
        String numbersToExtract = "12,1,4,52,7,8";

        String[] array = numbersToExtract.split(",");
        List<Integer> numbersToInt = new ArrayList<>();
        for (String number : array) {
            numbersToInt.add(Integer.parseInt(number));
        }

        IntSummaryStatistics min = numbersToInt.stream().min();
        System.out.println(numbersToInt);
    }
}