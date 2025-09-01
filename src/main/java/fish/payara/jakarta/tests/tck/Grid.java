package fish.payara.jakarta.tests.tck;

import java.util.List;

/**
 * Two-dimensional grid of boolean values used to simulate game of life.
 * <p>
 * Each cell can be either alive (true) or dead (false).
 * Class provides methods to simulate generation following rules
 *
 * @author Flavio, Rhys, Ismah
 */
public class Grid {
    private final int size;
    private final boolean[][] grid;
    
    public Grid (int size) {
        this.size = size;
        this.grid = new boolean[size][size];
    }
    
    public boolean get (int x, int y) {
        if (x < 0 || x >= this.size) {
            return false;
        }
        if (y < 0 || y >= this.size) {
            return false;
        }
        return this.grid[x][y];
    }
    
    public void put (int x, int y, boolean value) {
        if (x >= 0 && x < this.size && y >= 0 && y < this.size) {
            this.grid[x][y] = value;
        }
    }

    public int getLivingNeighbours(int x, int y) {
        int living = 0;

        for (int dx = -1; dx < 2; ++dx) {
            for (int dy = -1; dy < 2; ++dy) {
                if (!(dx == 0 && dy == 0) && this.get(x + dx, y + dy)) {
                    living++;
                }
            }
        }

        return living;
    }

    public int returnSize () {
        return size * size;
    }

    public boolean executeRules (int x, int y) {
        int neighboursCount = this.getLivingNeighbours(x, y);
        boolean cell = get(x, y);

        if (cell) {
            return neighboursCount == 2 || neighboursCount == 3;
        }
        return neighboursCount >= 3;
    }

    public Grid nextGeneration() {
        Grid nextGeneration = new Grid(size);

        // iterate through grid and check each cell
        for (int x = 0; x < size; x++ ) {
            for (int y = 0; y < size; y++){
                //check each cell and its neighbours
                nextGeneration.put(x, y, this.executeRules(x, y));
            }
        }
        return nextGeneration;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < size; y++) { //print the x & y along the sides with numbers (maybe) -- do it as decorator
            for (int x = 0; x < size; x++) {
                if (this.grid[x][y]) {
                    builder.append("O");
                } else {
                    builder.append(".");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
