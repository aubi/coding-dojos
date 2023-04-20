package fish.payara.codingdojo.eightqueens;

import java.util.List;
import java.util.Random;

/**
 *
 * @author james, kalin, aubi
 */
public class Board {

    private int size;
    private int numberOfPieces;
    private String[] positions;

    public Board(int size) {
        this.size = size;
        this.numberOfPieces = size;
        this.positions = new String[getSize()];
    }

    int getSize() {
        return size*size;
    }

    int getNumberOfPieces() {
        return numberOfPieces;
    }

    public List<String> getAllSolutions() {
        Random random = new Random();
        for(int i = 0; i < getSize(); i++){
            positions[random.nextInt(getSize())] = "Q";
        }
        return null;
    }

    @Override
    public String toString() {
        if (size == 1){
            return "[Q]";
        }
        return "";
    }
}
