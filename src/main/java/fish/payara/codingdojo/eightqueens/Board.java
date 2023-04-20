package fish.payara.codingdojo.eightqueens;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james, kalin, aubi
 */
public class Board {

    private int size;
    private int numberOfPieces;
    private String[][] positions;

    public Board(int size) {
        this.size = size;
        this.numberOfPieces = size;
        this.positions = new String[size][size];
    }

    int getSize() {
        return size*size;
    }

    int getNumberOfPieces() {
        return numberOfPieces;
    }

    public List<String> getAllSolutions() {
        //Random random = new Random();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                positions[x][y] = ".";
            }
        }
        List<String> solutions = new ArrayList<>();
        solve(0, 0, solutions);

//        for (int i = 0; i < getSize(); i++) {
//            positions[random.nextInt(getSize())] = "Q";
//        }
        return null;
    }

    @Override
    public String toString() {
        if (size == 1){
            return "[Q]";
        }
        return "";
    }

    /**
     * Try new queen on [x,y]
     */
    private void solve(int x, int y, List<String> solutions) {
        positions[x][y] = "Q";
        // TODO: check if this is solution
        // at the end
        // not conflicting
        // add to solution

        // TODO: try next line
        solve(0, y + 1, solutions);

        // cleanup
        positions[x][y] = ".";

        //? solve(x+1, y, solution)
    }
}
