/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fish.payara.codingdojo.java21toys;

import java.util.List;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Java21Toys {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        calcPreference(null);
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

    public static double calcHappiness(List<CarBrand> brands) {
        double happiness = 0.0;
        for (CarBrand brand : brands) {
            happiness += calcPreference(brand);
        }

        return happiness;
    }
}
