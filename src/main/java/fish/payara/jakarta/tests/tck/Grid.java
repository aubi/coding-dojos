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

    public int returnSize () {
        return size * size;
    }

}
