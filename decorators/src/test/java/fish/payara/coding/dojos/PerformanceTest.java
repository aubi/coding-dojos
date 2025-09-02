package fish.payara.coding.dojos;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PerformanceTest {

    @Test
    public void testStringContent() {
        String text = "hello, World! from Coding Dojo";
        TextStream stream1 = new RepeatedTextStream(text, 1_000_000);
        TextStream stream2 = new UpperCaseTextStream(stream1);

        assertEquals(30_000_000, stream2.getOutput().length());
        //assertEquals("hello, World! from Coding Dojo", stream.getOutput());
    }

    @Test
    public void testWrappedStringContent() {
        int repeat = 1_000;
        String text = "hello, World! from Coding Dojo";
        TextStream stream1 = new RepeatedTextStream(text, repeat);
        TextStream stream2 = new TextWrapStream(stream1, 10);

        System.out.println(stream2.getOutput().length());
        assertEquals(-1, stream2.getOutput().length());
    }
}
