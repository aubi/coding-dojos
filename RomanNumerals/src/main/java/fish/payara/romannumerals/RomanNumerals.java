package fish.payara.romannumerals;

/**
 * Convert numbers to Roman syntax.
 *
 * @author aubi
 */
public class RomanNumerals {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static String convert(int num) {
        if (num == 4) {
            return "IV";
        }

        if (num == 5) {
            return "V";
        }

        if (num > 5) {

        }

        return "I".repeat(num);
    }
}
