
package fish.payara.onebrcpayara;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Results:
111,772,193 lines
Without parallel addToData
real	1m1.241s
user	1m34.518s
sys	0m5.860s

With parallel addToData
real	1m22.249s
user	4m48.438s
sys	1m13.989s
 */

/**
 * 1 Billion Row Challenge. See https://1brc.dev/
 *
 * @author Petr
 * @author Fabio
 * @author Rhys
 */
public class OneBRCPayara {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        System.out.println("Available CPU Cores:" + Runtime.getRuntime().availableProcessors());

        Map<String, List<Double>> stats = new HashMap<>();
//        Map<String, List<Double>> stats = new ConcurrentHashMap<>();
        System.out.println("Let's read the file");
        try (Reader file = new BufferedReader(new FileReader("../weather_stations.csv"), 1024 * 1024); PrintStream out = new PrintStream(new FileOutputStream("stats.csv"))) {
            Scanner scanner = new Scanner(file);
            //Let's skip the first 2 "header" lines
            scanner.nextLine();
            scanner.nextLine();
            try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
//                    es.submit(() -> {
                        addToData(line, stats);
//                    });
                }
            }
            System.out.println("Calculating statistics");
            List<Statistics> results = Collections.synchronizedList(new ArrayList<>());
            try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
                for (Map.Entry<String, List<Double>> entry : stats.entrySet()) {
                    es.submit(() -> {
                        double min = Double.POSITIVE_INFINITY;
                        double max = Double.NEGATIVE_INFINITY;
                        double sum = 0f;
                        for (double f : entry.getValue()) {
                            if (f < min) {
                                min = f;
                            }
                            if (f > max) {
                                max = f;
                            }
                            sum += f;
                        }
                        results.add(new Statistics(entry.getKey(), min, (sum / entry.getValue().size()), max));
                    });
                }
            }
            System.out.println("Sorting");
            Collections.sort(results, (r1, r2) -> r1.name().compareTo(r2.name()));
            System.out.println("Printing");
            results.stream()
                    .forEach(s -> out.println("%s;%.1f;%.1f;%.1f".formatted(s.name(), s.min(), s.mean(), s.max())));
        }
    }

    private static void addToData(String line, Map<String, List<Double>> stats) throws NumberFormatException {
        int indexOfSemicolon = line.indexOf(';');
        //System.out.println(Arrays.toString(lineParts));
        String name = line.substring(0, indexOfSemicolon);
        Double value = Double.valueOf(line.substring(indexOfSemicolon + 1));
        stats.compute(name, (k, v) -> updatedList(k, v, value));
    }

    private static List<Double> updatedList(String k, List<Double> v, Double value) {
        if (v == null) {
            v = new ArrayList<>(List.of(value));
        }
        v.add(value);
        return v;
    }

    public record Statistics(
            String name,
            double min,
            double mean,
            double max) {

    }
}
