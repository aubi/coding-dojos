package fish.payara.bean;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorDefinition;
import jakarta.enterprise.concurrent.ManagedExecutorService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
@ManagedExecutorDefinition(name = "java:app/myMES", maxAsync = 2)

public class FactorialService {

    @Resource(lookup = "java:app/myMES")
    private ManagedExecutorService mes;


    public List<String> makeFactorial(String input) {
        String[] inputs = input.split(",");
        List<String> result = new ArrayList<>();
        for (String string : inputs) {
            int value = Integer.parseInt(string);
            int total = 1;
            for (int x = 1; x <= value; x++){
                total = total * x;
            }
            result.add(total + "");
        }

        return result;
    }

    public List<String> calculateParallelFactorial(String input) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        String[] inputs = input.split(",");
        List<String> result = new ArrayList<>();
        List<Future<BigInteger>> futures = new ArrayList<>();
        for (String string : inputs) {
            futures.add(mes.submit(() -> {
                int value = Integer.parseInt(string);
                BigInteger total = BigInteger.ONE;
                for (int x = 1; x <= value; x++) {
                    total = total.multiply(BigInteger.valueOf(x));
                }
                return total;
            }));
        }

        futures.forEach(integerFuture -> {
            try {
                result.add(String.valueOf(integerFuture.get()));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        long end = System.currentTimeMillis();
        result.add(" ");
        result.add(end-start+"ms");
        return result;
    }
}
