package fish.payara.jakarta.tests.tck;

import java.util.List;

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
        if (x >= 0 && x < this.size && y > 0 && y < this.size) {
            this.grid[x][y] = value;
        }
    }


    /*
     1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
     x = dead
     o = alive
            oxx
            oxo

   2. Any live cell with more than three live neighbours dies, as if by overcrowding.
   3. Any live cell with two or three live neighbours lives on to the next generation.
   4. Any dead cell with exactly three live neighbours becomes a live cell.
     */

//    public boolean isDead (int x, int y) {}
//
//    public boolean isAlive (int x, int y) {}

    public boolean checkNeighbours (int x, int y) {
        int count = 0;
        //go thru each row at a time
        if (this.grid[x-1][y]) {
            count++;
        }
        if (this.grid[x+1][y]) {
            count++;
        }
        if (this.grid[x][y-1]) {
            count++;
        }
        if (this.grid[x][y+1]) {
            count++;
        }
        return count >= 2;
    }
    
    public List<Boolean> getNeighbours (int x, int y) {
        return List.of(
            this.get(x + 1, y),
            this.get(x - 1, y),
            this.get(x, y + 1),
            this.get(x, y - 1)
        );
    }

    public int returnSize () {
        return size * size;
    }

    public void executeRules (int x, int y) {
        List<Boolean> neighbours = this.getNeighbours(x, y);
        if (neighbours.stream().filter(neighbour -> neighbour).count() < 2) {
            this.put(x, y, false);
        }
    }

    public void nextGeneration() {

    }
}
