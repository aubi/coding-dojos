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

        DefaultNumberProviderFactory factory = new DefaultNumberProviderFactory();
        NumberProvider<Integer> provider = factory.createProvider(numbers);

        CalculationStrategy<Integer> strategy = new IterativeCalculationStrategy<>();

        CalculationContext<Integer> context = new CalculationContext<>(provider, strategy);
        Optional<Integer> result = context.executeCalculation();

        result.ifPresentOrElse(
                r -> System.out.println("Result is: " + r),
                () -> System.err.println("No result produced")
        );
    }
}

class DefaultNumberProviderFactory {
    public <T extends Number> NumberProvider<T> createProvider(List<T> data) {
        return new ListNumberProvider<>(data);
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

// Strategy pattern for calculation (unnecessary)
interface CalculationStrategy<T extends Number> {

    Optional<Integer> calculate(List<T> numbers);
}

// Only one implementation
class IterativeCalculationStrategy<T extends Number> implements CalculationStrategy<T> {

    @Override
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

// Context object coordinating everything
class CalculationContext<T extends Number> {

    private final NumberProvider<T> provider;
    private final CalculationStrategy<T> strategy;

    public CalculationContext(NumberProvider<T> provider, CalculationStrategy<T> strategy) {
        this.provider = provider;
        this.strategy = strategy;
    }

    public Optional<Integer> executeCalculation() {
        try {
            return strategy.calculate(provider.getNumbers());
        } catch (Exception e) {
            System.err.println("Error executing calculation: " + e.getMessage());
            return Optional.empty();
        }
    }
}
