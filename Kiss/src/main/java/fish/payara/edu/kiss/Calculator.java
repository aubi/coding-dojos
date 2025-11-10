package fish.payara.edu.kiss;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Calculator {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Result is: " + numbers.stream().mapToInt(Integer::intValue).sum());
    }
}

