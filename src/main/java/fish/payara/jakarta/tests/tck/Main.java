package fish.payara.jakarta.tests.tck;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Grid grid = new Grid(25);
        grid.put(15, 15, true);
        grid.put(14, 16, true);
        grid.put(15, 16, true);
        grid.put(15, 17, true);
        grid.put(16, 17, true);

        for (int i = 0; i < 50; ++i) {
            System.out.println(grid);
            System.out.println();
            grid = grid.nextGeneration();
            Thread.sleep(500L);
        }
    }
}