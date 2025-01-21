/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fish.payara.codingdojo.java21toys;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Java21Toys {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public double calcPreference(CarBrand brand) {
        return switch (brand) {
            case AUDI -> 0.3;
            case VW -> 0.9;
            case TESLA -> 1.0;
            case FIAT -> 0.02;
            case PORSCHE -> 0.8;
        };
    }
}
