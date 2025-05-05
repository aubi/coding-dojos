package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

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

        IntStream intStream = numbersToInt.stream().mapToInt(Integer::intValue);

        IntSummaryStatistics stats = intStream.collect(IntSummaryStatistics::new,
                IntSummaryStatistics::accept,
                IntSummaryStatistics::combine);

        System.out.println(stats);
    }
}