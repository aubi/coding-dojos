/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fish.payara.onebrcpayara;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class OneBRCPayara {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Let's read the file");

        Map<String, List<Double>> stats = new TreeMap<>();
        try (Reader file = new BufferedReader(new FileReader("OneBRCPayara/data/weather_stations.csv"), 1024 * 1024)) {
            Scanner scanner = new Scanner(file);
            //Let's skip the first 2 "header" lines
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineParts = line.split(";");
                //System.out.println(Arrays.toString(lineParts));
                if(!stats.containsKey(lineParts[0])) {
                    stats.put(lineParts[0], new ArrayList<>());
                }
                stats.get(lineParts[0]).add(Double.parseDouble(lineParts[1]));
            }
            for (Map.Entry<String, List<Double>> entry : stats.entrySet()) {
                double min = Double.POSITIVE_INFINITY;
                double max = Double.NEGATIVE_INFINITY;
                double sum = 0f;
                for(double f : entry.getValue()) {
                    if(f < min) {
                        min = f;
                    }
                    if(f > max) {
                        max = f;
                    }
                    sum += f;
                }
                System.out.println(new Statistics(entry.getKey(), min, (sum/entry.getValue().size()), max));
            }
        }
    }

    public record Statistics(
            String name,
            double min,
            double mean,
            double max) {

    }
}
