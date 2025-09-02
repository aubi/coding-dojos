package fish.payara.coding.dojos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecoratorTest {

    @Test
    public void testStringContent() {
        String text = "hello, World! from Coding Dojo";
        TextStream stream = new BaseTextStream();
        assertEquals(stream.getOutput(), "Hello World!");
    }


}
