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

        IterativeCalculationStrategy<Integer> strategy = new IterativeCalculationStrategy<>();
        Optional<Integer> result = strategy.calculate(numbers);

        result.ifPresentOrElse(
                r -> System.out.println("Result is: " + r),
                () -> System.err.println("No result produced")
        );
    }
}

// Only one implementation
class IterativeCalculationStrategy<T extends Number> {
    public Optional<Integer> calculate(List<T> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Optional.empty();
        }
        int res = 0;
        for (T n : numbers) {
            res += n.intValue();
        }
        return Optional.of(res);
    }
}
