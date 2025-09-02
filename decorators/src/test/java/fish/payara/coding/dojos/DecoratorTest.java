package fish.payara.coding.dojos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecoratorTest {

    @Test
    public void testStringContent() {
        String text = "hello, World! from Coding Dojo";
        TextStream stream = new BaseTextStream(text);
        assertEquals("hello, World! from Coding Dojo", stream.getOutput());
    }

    @Test
    public void testUpperStringContent() {
        String text = "hello, World! from Coding Dojo";
        TextStream stream = new UpperCaseTextStream(new BaseTextStream(text));
        assertEquals("HELLO, WORLD! FROM CODING DOJO", stream.getOutput());
    }


}
