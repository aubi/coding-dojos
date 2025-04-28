package fish.payara.calculator;
/**
    Simple calculator class.
    <p>
    This class provides basic arithmetic operations: addition, subtraction, multiplication, and division.
 */
public class Calculator {
    public static double add (double value1, double value2) {
        return value1 + value2;
    }

    public static double subtract (double value1, double value2) {
        return value1 - value2;
    }

    public static double divide (double numerator, double denominator) {
        return numerator / denominator;
    }

    public static double multiply (double value1, double value2) {
       return value1 * value2;
    }
}
