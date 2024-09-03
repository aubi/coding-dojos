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
        } else if (num >= 5 && num < 9) {
            return "V" + "I".repeat(num-5);
        } else if (num == 9) {
            return "IX";
        }
        return "I".repeat(num);
    }
}
