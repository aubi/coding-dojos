/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fish.payara.codingdojo.java21toys;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class Java21Toys {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        calcPreference(null);
        System.out.println(calcHappiness(Arrays.asList(CarBrand.values())));

        System.out.println("Happiness by country");
        Map<String, Double> happyByOrigin = calcHappinessByOrigin(Arrays.stream(CarBrand.values()).toList());
        System.out.println(happyByOrigin);

        System.out.println("Selected Happiness by country");
        Map<String, Double> selectedHappinessByOrigin = calcHappinessByOriginSelected(Arrays.stream(CarBrand.values()).toList());
        System.out.println(selectedHappinessByOrigin);

        System.out.println("Create Happiness chart by country ");
        happinessByCountryChart();
    }

    public static double calcPreference(CarBrand brand) {
        return switch (brand) {
            case AUDI, SKODA ->
                0.3;
            case VW ->
                0.9;
            case TESLA ->
                1.0;
            case FIAT ->
                0.02;
            case PORSCHE ->
                0.8;
            case MARUTI ->
                0.6;
            case null ->
                0;
        };
    }

    public static String determineOrigin(CarBrand brand) {
        return switch (brand) {
            case AUDI, SKODA, VW, PORSCHE ->
                "Germany";
            case TESLA ->
                "USA";
            case FIAT ->
                "Italy";
            case MARUTI ->
                "India";
            case null ->
                "Nowhere";
        };
    }

    public static Double calcHappiness(List<CarBrand> brands) {
        return brands.stream()
                .mapToDouble(Java21Toys::calcPreference)
                .sum();
    }

    public static Map<String, Double> calcHappinessByOriginSelected(List<CarBrand> brands) {
        return brands.stream()
                .map(BrandPreferenceOrigin::of)
                .filter(bpo -> bpo.preference() > .5)
                .filter(bpo -> bpo.origin().equals("Germany") || bpo.origin().equals("USA"))
                .collect(Collectors.groupingBy(
                        BrandPreferenceOrigin::origin,
                        Collectors.summingDouble(BrandPreferenceOrigin::preference)
                ));
    }

    public static Map<String, Double> calcHappinessByOrigin(List<CarBrand> brands) {
        return brands.stream()
                .collect(Collectors.groupingBy(
                        Java21Toys::determineOrigin,
                        Collectors.summingDouble(Java21Toys::calcPreference)
                ));
    }

    public static void happinessByCountryChart() {
        try {
            String htmlContentStart
                    = """
                    <html>
                       <body>
                            <h2>Happiness by Country</h2>
                            <table>
                            <tr><th>Country</th><th>Preference</th></tr>
                    """;
            StringBuilder chart = new StringBuilder();
            for (Map.Entry<String, Double> entry : calcHappinessByOrigin(List.of(CarBrand.values())).entrySet()) {
                chart.append("<tr><td>")
                        .append(entry.getKey())
                        .append("</td><td>")
                        .append("#".repeat((int) (entry.getValue() * 100)))
                        .append("</td></tr>");
                chart.append("\n");
            }
            String htmlContentEnd
                    = """
                            </table>
                        </body>
                    </html>
                    """;

            String htmlContent = htmlContentStart + chart.toString() + htmlContentEnd;
            Files.writeString(Paths.get("happiness_chart.html"), htmlContent);
        } catch (IOException ex) {
            Logger.getLogger(Java21Toys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    record BrandPreferenceOrigin(CarBrand brand, double preference, String origin) {

        public static BrandPreferenceOrigin of(CarBrand brand) {
            return new BrandPreferenceOrigin(brand, Java21Toys.calcPreference(brand), Java21Toys.determineOrigin(brand));
        }
    }
}
