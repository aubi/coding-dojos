/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fish.payara.codingdojo.java21toys;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Java21Toys {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        calcPreference(null);
        System.out.println(calcHappiness(Arrays.asList(CarBrand.values())));

        System.out.println("Happiness by country");
        Map<String, Double> happyByOrigin = calcHappinessByOrigin(Arrays.stream(CarBrand.values()).toList());
        System.out.println(happyByOrigin);
    }

    public static double calcPreference(CarBrand brand) {
        return switch (brand) {
            case AUDI, SKODA -> 0.3;
            case VW -> 0.9;
            case TESLA -> 1.0;
            case FIAT -> 0.02;
            case PORSCHE -> 0.8;
            case null -> 0;
        };
    }

    public static String determineOrigin(CarBrand brand) {
        return switch (brand) {
            case AUDI, SKODA, VW, PORSCHE -> "Germany";
            case TESLA -> "USA";
            case FIAT -> "Italy";
            case null -> "Nowhere";
        };
    }

    public static Double calcHappiness(List<CarBrand> brands) {
        return brands.stream()
                .mapToDouble(Java21Toys::calcPreference)
                .sum();
    }

    public static Map<String, Double> calcHappinessByOrigin(List<CarBrand> brands) {
        return brands.stream()
                .collect(Collectors.groupingBy(
                        Java21Toys::determineOrigin,
                        Collectors.summingDouble(Java21Toys::calcPreference)
                ));
    }
}
