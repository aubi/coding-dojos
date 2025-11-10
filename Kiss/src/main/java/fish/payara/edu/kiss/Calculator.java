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
        
        NumberProvider<Integer> provider = new ListNumberProvider<>(numbers);

        IterativeCalculationStrategy<Integer> strategy = new IterativeCalculationStrategy<>();
        Optional<Integer> result = strategy.calculate(numbers);

        result.ifPresentOrElse(
                r -> System.out.println("Result is: " + r),
                () -> System.err.println("No result produced")
        );
    }
}

// Abstract provider interface
interface NumberProvider<T extends Number> {

    List<T> getNumbers();
}

class ListNumberProvider<T extends Number> implements NumberProvider<T> {

    private final List<T> data;

    public ListNumberProvider(List<T> data) {
        // copy for immutability (unnecessary)
        this.data = new ArrayList<>(data);
    }

    @Override
    public List<T> getNumbers() {
        return new ArrayList<>(data);
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
