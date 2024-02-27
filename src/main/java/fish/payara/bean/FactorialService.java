package fish.payara.bean;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> calculateParallelFactorial(String input) {
        String[] inputs = input.split(",");
        List<String> result = new ArrayList<>();
        for (String string : inputs) {

            mes.submit(() -> {
                int value = Integer.parseInt(string);
                int total = 1;
                for (int x = 1; x <= value; x++){
                    total = total * x;
                }
                result.add(total + "");
            });
        }
        return result;
    }
}
