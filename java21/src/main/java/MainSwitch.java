import java.util.HashSet;
import java.util.Set;

public class MainSwitch {

    enum Color {
        RED, GREEN, BLUE, YELLOW, PINK
    }

    public static void main(String[] args) {
        Set<Color> colorSet = new HashSet<>(Set.of(Color.RED, Color.GREEN));

        for (Color color : colorSet) {
            boolean likedColor = switch (color) {
                case RED, GREEN -> true;
                case BLUE, YELLOW, PINK -> false;
            };
            System.out.println(likedColor);
        }
    }
}
