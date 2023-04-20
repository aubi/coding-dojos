package fish.payara.codingdojo.eightqueens;

/**
 *
 * @author james, kalin, aubi
 */
public class Board {

    private int size;

    public Board(int size) {
        this.size = size;
    }

    int getSize() {
        return getNumberOfPieces() * getNumberOfPieces();
    }

    int getNumberOfPieces() {
        return 8;
    }

}
