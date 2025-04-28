package fish.payara.calculator;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {

    @Test
    public void testAdd() {
        int number1 = 1;
        int number2 = 2;
        Assert.assertEquals(3, Calculator.add(number1, number2), 0);
    }

    @Test
    public void testSubtract () {
        int n1 = 10;
        int n2 = 4;
        Assert.assertEquals(6, Calculator.subtract(n1, n2), 0);
    }

    @Test
    public void testMultiply () {
        int n1 = 5;
        int n2 = 6;
        Assert.assertEquals(30, Calculator.multiply(n1, n2), 0);
    }

    @Test
    public void testDivide () {
        int n1 = 100;
        int n2 = 10;
        Assert.assertEquals(10.0, Calculator.divide(n1, n2), 0.001);
    }

    @Test
    public void multiplyAndDivide () {
        int n1 = 10;
        double n2 = Calculator.divide(n1, 3);
        Assert.assertEquals(10, Calculator.multiply(n2, 3), 0.001);
    }
}
