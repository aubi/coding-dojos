import org.example.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {

    @Test
    public void testAdd() {
        int number1 = 1;
        int number2 = 2;
        Assert.assertEquals(Calculator.add(number1, number2), 3);
    }

    @Test
    public void testSubtract () {
        int n1 = 10;
        int n2 = 4;
        Assert.assertEquals(Calculator.subtract(n1, n2), 6);
    }

    @Test
    public void testMultiply () {
        int n1 = 5;
        int n2 = 6;
        Assert.assertEquals(Calculator.multiply(5, 6), 30);
    }

    @Test
    public void testDivide () {
        int n1 = 100;
        int n2 = 10;
        Assert.assertEquals(Calculator.divide(n1, n2), 10.0);
    }
}
