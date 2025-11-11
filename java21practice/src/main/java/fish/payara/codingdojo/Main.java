package fish.payara.codingdojo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        RecordsTest recordsTest = new RecordsTest("loginpath", "loginname");
        System.out.println(recordsTest);
        Set<RecordsTest> mutableSet = new HashSet<>();
        mutableSet.add(recordsTest);
        mutableSet.add(recordsTest);
        mutableSet.add(recordsTest);
        System.out.println(mutableSet);
        Map<RecordsTest, Integer> map = new HashMap<>();
        map.put(recordsTest, 1);
        System.out.println(map);
        map.put(recordsTest, 2);
        System.out.println(map);
        RecordsTest recordsTestPath = new RecordsTest("testpath");
        System.out.println(recordsTestPath);
    }
}
