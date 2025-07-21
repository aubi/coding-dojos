package fish.payara.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BowlingGame {

    private List<Frame> frames = new ArrayList<>();
    private int strike = 10;
    // aaray for turns

    public void roll(int pins) {
        if (frames.isEmpty()) {
            frames.add(new Frame(pins, Optional.empty(), Optional.empty()));
        }
        else {
            if (frames.size() == 10 || (frames.getLast().roll2().isEmpty() && frames.getFirst().roll1() != strike)) {
                frames.set(frames.size() - 1, frames.getLast().addRoll(pins));
            }
            else {
                frames.add(new Frame(pins, Optional.empty(), Optional.empty()));
            }
        }
    }

    public int calcTotalScore() {
        int score = 0;
        // collect the score for each frame
        // add the score for each frame to rolls
        //totalScore = total of rolls
//        for (int i = 0; i < currentRoll; i++) {
//            if (currentRoll % 2 == 0) {
//                score += rolls[i];
//            }
//            score += rolls[i];
//        }
       return score;
    }
}
