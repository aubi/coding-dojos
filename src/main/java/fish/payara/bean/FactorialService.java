package fish.payara.bean;

import java.util.ArrayList;
import java.util.List;

public class FactorialService {
    
    
    public List<String> makeFactorial(String input) {
        String[] inputs = input.split(",");
        List<String> result = new ArrayList<>();
        for (String string : inputs) {
            int value = Integer.parseInt(string);
            int total = 1;
            for (int x =1; x < value; x++){
                total = total * x;
            }
            result.add(total + "");
        }

        return result;
    }
}
