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

        //Go through a generation
        grid.nextGeneration();

        // check grid 1,1 to make sure it is false
        Assert.assertFalse(grid.get(1, 1));
    }

    @Test
    public void testDeadCellSpawnsWithinFourNeighbours() {
        Grid grid = new Grid(5);

        //dead cell we are testing with overcrowding
        grid.put(1,1,true);

        grid.put(0,1,true); //left
        grid.put(2,1,true); //right
        grid.put(1,2,true); //up
        grid.put(1,0,true); //down

        //Go through a generation
        grid.nextGeneration();

        // check grid 1,1 to make sure it is false
        Assert.assertFalse(grid.get(1, 1));
    }

    // Test a grid with all alive cells
//    @Test
//    public void testGenerate


}
