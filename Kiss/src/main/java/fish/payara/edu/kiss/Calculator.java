package fish.payara.edu.kiss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Calculator {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Integer result = calculate(numbers);
        System.out.println("Result is: " + result);
    }

    public static Integer calculate(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}

