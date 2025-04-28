package fish.payara.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TestCalculator {

    @Test
    public void testAdd() {
        BigDecimal number1 =BigDecimal.valueOf(1);
        BigDecimal number2 = BigDecimal.valueOf(2);
        Assert.assertEquals(BigDecimal.valueOf(3), Calculator.add(number1, number2));
    }

    @Test
    public void testSubtract () {
        BigDecimal n1 = BigDecimal.valueOf(10);
        BigDecimal n2 = BigDecimal.valueOf(4);
        Assert.assertEquals(BigDecimal.valueOf(6), Calculator.subtract(n1, n2));
    }

    @Test
    public void testMultiply () {
        BigDecimal n1 = BigDecimal.valueOf(5);
        BigDecimal n2 = BigDecimal.valueOf(6);
        Assert.assertEquals(BigDecimal.valueOf(30), Calculator.multiply(n1, n2));
    }

    @Test
    public void testDivide () {
        BigDecimal n1 = BigDecimal.valueOf(100);
        BigDecimal n2 = BigDecimal.valueOf(10);
        Assert.assertEquals(BigDecimal.valueOf(10), Calculator.divide(n1, n2));
    }

    @Test
    public void multiplyAndDivide () {
        BigDecimal n1 = BigDecimal.valueOf(10);
        BigDecimal n2 = Calculator.divide(n1, BigDecimal.valueOf(3));
        Assert.assertEquals(BigDecimal.valueOf(10), Calculator.multiply(n2, BigDecimal.valueOf(3)));
    }
}
