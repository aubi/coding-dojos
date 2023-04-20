package fish.payara.codingdojo.eightqueens;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EightQueensTest {

    @Test
    public void testThisWorks() {
        assertTrue(true);
    }

    @Test
    public void testBoard() {
        Board board = new Board();
        assertTrue(board.getSize() == 64);
        assertTrue(board.getNumberOfPieces() == 8);
        
    }

}
