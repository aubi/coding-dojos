import fish.payara.jakarta.tests.tck.Grid;
import org.junit.Assert;
import org.junit.Test;


public class GameOfLifeTest {

    @Test
    public void testGridSize(){
        Grid grid = new Grid(5);

        Assert.assertEquals(25,grid.returnSize());
    }

    // Test a grid with all alive cells
//    @Test
//    public void testGenerate


}
