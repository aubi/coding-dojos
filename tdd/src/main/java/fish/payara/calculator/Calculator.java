package fish.payara.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Simple calculator class.
 * <p> This class provides basic arithmetic operations: addition, subtraction, multiplication, and division. </p>
 */
public class Calculator {
    public static BigDecimal add (BigDecimal value1, BigDecimal value2) {
        return value1.add(value2);
    }

    public static BigDecimal subtract (BigDecimal value1, BigDecimal value2) {
        return value1.subtract(value2);
    }

    public static BigDecimal divide (BigDecimal numerator, BigDecimal denominator) {
        return numerator.divide(denominator, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiply (BigDecimal value1, BigDecimal value2) {
       return value1.multiply(value2);
    }
}
