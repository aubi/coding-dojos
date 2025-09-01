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
    
    public List<Boolean> getNeighbours (int x, int y) {
        return List.of(
            this.get(x + 1, y),
            this.get(x - 1, y),
            this.get(x, y + 1),
            this.get(x, y - 1),
            this.get(x + 1, y + 1),
            this.get(x + 1, y - 1),
            this.get(x - 1, y + 1),
            this.get(x - 1, y - 1)
        );
    }

    public int returnSize () {
        return size * size;
    }

    public boolean executeRules (int x, int y) {
        List<Boolean> neighbours = this.getNeighbours(x, y);
        long neighboursCount = neighbours.stream().filter(neighbour -> neighbour).count();
        boolean cell = get(x, y);

//        Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
        if (cell && neighboursCount < 2) {
            return false;
        }
//        Any live cell with two or three live neighbours lives on to the next generation.
        if (cell && (neighboursCount == 2 || neighboursCount == 3)) {
            return true;
        }
//        Any dead cell with exactly three live neighbours becomes a live cell.
        if (!cell && neighboursCount >= 3) {
            return true;
        }
        // Any live cell with more than three live neighbours dies, as if by overcrowding.
        if (cell && neighboursCount > 3) {
            return false;
        }
        return false;
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
