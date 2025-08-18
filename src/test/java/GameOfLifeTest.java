import fish.payara.jakarta.tests.tck.Grid;
import org.junit.Assert;
import org.junit.Test;


public class GameOfLifeTest {

    @Test
    public void testGridSize(){
        Grid grid = new Grid(5);

        Assert.assertEquals(25,grid.returnSize());
    }

    @Test
    public void testLiveCellDiesWithOneorLessNeighbour() {
        Grid grid = new Grid(5);

        grid.put(1,1,true);
        grid.put(2,1,true);

        //Go throught a generation
        grid.nextGeneration();
        // check grid 1,1 to make sure it is false
        Assert.assertEquals(false, grid.get(1,1));
    }

    @Test
    public void testDeadCellSpawnsWithinFourNeighbours() {
        Grid grid = new Grid(5);

        grid.put(1,1,true);
        grid.put(2,1,true);

        //Go throught a generation
        grid.nextGeneration();
        // check grid 1,1 to make sure it is false
        Assert.assertEquals(false, grid.get(1,1));
    }

    // Test a grid with all alive cells
//    @Test
//    public void testGenerate


}
