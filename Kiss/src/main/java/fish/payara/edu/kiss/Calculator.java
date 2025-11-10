
import module java.base;

public void main() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    System.out.println("Result is: " + numbers.stream().mapToInt(Integer::intValue).sum());
}

