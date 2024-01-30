package fish.payara.hello;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ProcessingManager {

    private static long counter = 0;

    public String expensiveComputation(int number) {
        // concatenate a number of random uuids together
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(UUID.randomUUID().toString());
            counter++;
        }
        return sb.toString();
    }

    public long getCounter() {
        return counter;
    }

}
