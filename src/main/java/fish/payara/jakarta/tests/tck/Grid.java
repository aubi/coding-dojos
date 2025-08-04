package fish.payara.jakarta.tests.tck;

public class Grid {
    private final int size;
    private final boolean[][] grid;
    
    public Grid (int size) {
        this.size = size;
        this.grid = new boolean[size][size];
    }
    
    public boolean get (int x, int y) {
        return this.grid[x][y];
    }
    
    public void put (int x, int y, boolean value) {
        this.grid[x][y] = value;
    }
}
