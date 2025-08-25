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
        Grid newGen = grid.nextGeneration();

        // check grid 1,1 to make sure it is false
        Assert.assertFalse(newGen.get(1, 1));
    }

    @Test
    public void testCellDiesWithoutNeighbours() {
        Grid grid = new Grid(5);

        grid.put(1, 1, true);

        //Go through a generation
        grid.nextGeneration();

        // check grid 1,1 to make sure it is false
        Assert.assertFalse(grid.get(1, 1));
    }

    @Test
    public void testCellDiesWithinFourNeighbours() {
        Grid grid = new Grid(5);

        //dead cell we are testing with overcrowding
        grid.put(1,1,true);

        grid.put(0,1,true); //left
        grid.put(2,1,true); //right
        grid.put(1,2,true); //up
        grid.put(1,0,true); //down

        // print current grid
        System.out.println(grid.toString());

        //Go through a generation
        Grid newGen = grid.nextGeneration();

        // print newGen grid
        System.out.println(newGen.toString());

        // check grid 1,1 to make sure it is false
        Assert.assertFalse(newGen.get(1, 1));
    }

    @Test
    public void testCellSpawnsWithinFourNeighbours() {
        Grid grid = new Grid(5);

        //dead cell we are testing with overcrowding
        grid.put(1, 1, false);

        grid.put(0, 1, true); //left
        grid.put(2, 1, true); //right
        grid.put(1, 2, true); //down
        grid.put(1, 0, true); //up

        //Go through a generation
        grid.nextGeneration();

        // check grid 1,1 to make sure it is true
        Assert.assertTrue(grid.get(1, 1));
    }

    @Test
    public void testCellSpawnsWithinThreeNeighbours() {
        Grid grid = new Grid(5);

        //dead cell we are testing with overcrowding
        grid.put(1, 1, false);

        grid.put(0, 1, true); //left
        grid.put(2, 1, true); //right
        grid.put(1, 2, true); //down

        //Go through a generation
        Grid newGen = grid.nextGeneration();

        // check grid 1,1 to make sure it is true
        Assert.assertTrue(newGen.get(1, 1));
    }

    @Test
    public void testCellSurvivesWithTwoNeighbours() {
        Grid grid = new Grid(5);

        grid.put(1, 1, true);

        grid.put(1, 2, true);
        grid.put(1, 0, true);

        grid.nextGeneration();

        Assert.assertTrue(grid.get(1, 1));
    }

    @Test
    public void testCellSurvivesWithThreeNeighbours() {
        Grid grid = new Grid(5);

        grid.put(1, 1, true);

        grid.put(1, 2, true);
        grid.put(1, 0, true);
        grid.put(0, 1, true);

        grid.nextGeneration();

        Assert.assertTrue(grid.get(1, 1));
    }

    // Test a grid with all alive cells
//    @Test
//    public void testGenerate


}
