package fish.payara.codingdojo.eightqueens;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author james, kalin, aubi
 */
public class Board {
    private static final String QUEEN = "Q";

    private int size;
    private int numberOfPieces;
    private String[][] positions;
    private List<String> solutions;

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
        solutions = new ArrayList<>();

        solve(0, 0);

//        for (int i = 0; i < getSize(); i++) {
//            positions[random.nextInt(getSize())] = "Q";
//        }
        return solutions;
    }

    @Override
    public String toString() {
        if (size == 1){
            return "[Q]";
        }
        return "";
    }

    public static void main(String[] args) {
        Board board = new Board(4);

        List<String> solutions = board.getAllSolutions();

        System.out.println(solutions.stream().collect(Collectors.joining("\n\n")));

    }
    /**
     * Try new queen on [x,y]
     */
    private void solve(int x, int y) {
        if (y >= size) {
            addSolution();
            return; // We have a solution
        }
        if (x >= size) {
            return; //Just continue looking
        }
        // TODO: check if this is solution
        if (checkPosition(x, y)) {
            // viable partial solution
            positions[x][y] = QUEEN;
            // It can only be the solution if there are the correct number of pieces
            // at the end
            // not conflicting
            // add to solution

            // TODO: try next line
            solve(0, y + 1);

            // cleanup
            positions[x][y] = ".";
        }

        solve(x+1, y);
    }

    private boolean checkPosition(int x, int y){
        for (int i = 1; i < size; i++){
            if (getPosition(x-i, y-i) == QUEEN) {
                return false;
            }
            if (getPosition(x, y - i) == QUEEN) {
                return false;
            }
            if (getPosition(x + i, y - i) == QUEEN) {
                return false;
            }
        }
        return true;
    }

    private String getPosition(int x, int y) {
        if (x < 0 || x >= size) {
            return ".";
        }
        if (y < 0 || y >= size) {
            return ".";
        }
        return positions[x][y];
    }

    private void addSolution() {
        StringBuilder sol = new StringBuilder();
        for (int x = 0; x < size; x++) {
            sol.append("[");
            for (int y = 0; y < size; y++) {
                sol.append(positions[x][y]);
            }
            sol.append("]\n");
        }
        solutions.add(sol.toString());
    }
}
