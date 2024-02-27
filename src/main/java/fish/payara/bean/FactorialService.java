package fish.payara.bean;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FactorialService {

    @Resource
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
        for (String string : inputs) {

            Future<Integer> output = mes.submit(() -> {
                int value = Integer.parseInt(string);
                int total = 1;
                for (int x = 1; x <= value; x++) {
                    total = total * x;
                }
                return total;
            });
            result.add(String.valueOf(output.get()));
        }
        long end = System.currentTimeMillis();
        result.add(" ");
        result.add(end-start+"ms");
        return result;
    }
}
