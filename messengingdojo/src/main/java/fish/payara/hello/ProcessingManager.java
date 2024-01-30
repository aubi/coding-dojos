package fish.payara.hello;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ProcessingManager {

    public String expensiveComputation(int number) {
        // concatenate a number of random uuids together
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(UUID.randomUUID().toString());
        }
        return sb.toString();
    }
}
