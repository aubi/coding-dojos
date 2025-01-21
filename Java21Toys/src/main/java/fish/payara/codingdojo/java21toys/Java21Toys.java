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
        double pref = 0;
        switch (brand) {
            case AUDI:
                pref = 0.3;
                break;
            case VW:
                pref = 0.9;
                break;
            case TESLA:
                pref = 1.0;
                break;
            default:
                throw new IllegalStateException("Unexpected brand: " + brand);
        }
        return pref;
    }
}
