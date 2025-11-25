import fish.payara.Film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> actorList = new ArrayList<>(Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"));
        Film film1 = new Film("Inception", actorList);
        System.out.println(film1.hashCode());
        Set<Film> films = new HashSet<>(Set.of(
                film1,
                new Film("Matrix", List.of("Keanu Reaves", "Trinity"))
        ));
        actorList.add("Ellen Page");
        Film film2 = new Film("Inception", actorList);
        System.out.println(films.contains(film2));
        System.out.println(film2.hashCode());
    }
}
