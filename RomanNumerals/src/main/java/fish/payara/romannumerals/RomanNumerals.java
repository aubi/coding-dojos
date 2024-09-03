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
        if (num == 50) {
            return "L";
        }
        else if (num == 40) {
            return "XL";
        }
        else if (num > 40 && num < 44) {
            return "XL" + repeatI(num, 40);
        }
        
        if (num >= 10) {
            int tens = num / 10;
            answer.append("X".repeat(tens));
            num -= tens * 10;
        }
        return convertLessThan10(answer , num);
    }
    
    private static String convertLessThan10(StringBuilder answer , int num) {
       if (num == 9) {
            answer.append("IX");
        } else if (num >= 5) {
            answer.append("V").append(repeatI(num, 5));
        } else if (num == 4) {
            answer.append("IV");
        } else {
            answer.append("I".repeat(num));
        }
        return answer.toString();
    }

    private static String repeatI(int num, int count) {
        return "I".repeat(num - count);
    }
}
