package fish.payara.codingdojo.eightqueens;

import java.util.List;

/**
 *
 * @author james, kalin, aubi
 */
public class Board {

    private int size;
    private int numberOfPieces;

    public Board(int size) {
        this.size = size;
        this.numberOfPieces = size;
    }

    int getSize() {
        return size*size;
    }

    int getNumberOfPieces() {
        return numberOfPieces;
    }

    public List<String> getAllSolutions() {
        return null;
    }

}
