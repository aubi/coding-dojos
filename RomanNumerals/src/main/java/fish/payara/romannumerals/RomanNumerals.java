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
            return "V" + repeatI(num, 5);
        } else if (num == 9) {
            return "IX";
        } else if (num >= 10 && num < 14) {
            return "X" + repeatI(num, 10);
        } else if (num == 14) {
            return "XIV";
        } else if (num >= 15 && num < 19) {
            return "XV" + repeatI(num, 15);
        }
        return "I".repeat(num);
    }

    private static String repeatI(int num, int count) {
        return "I".repeat(num - count);
    }
}
