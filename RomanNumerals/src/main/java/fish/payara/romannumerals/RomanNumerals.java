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
        StringBuilder answer = new StringBuilder();

        if (num >= 10) {
            int tens = num / 10;
            answer.append("X".repeat(tens));
            num -= tens;
        }

        if (num == 19) {
            return "XIX";
        } else if (num >= 15) {
            return "XV" + repeatI(num, 15);
        } else if (num == 14) {
            return "XIV";
        } else if (num >= 10) {
            return "X" + repeatI(num, 10);
        } else if (num == 9) {
            return "IX";
        } else if (num >= 5) {
            return "V" + repeatI(num, 5);
        } else if (num == 4) {
            return "IV";
        }
        answer.append("I".repeat(num));
        return answer.toString();
    }

    private static String repeatI(int num, int count) {
        return "I".repeat(num - count);
    }
}
