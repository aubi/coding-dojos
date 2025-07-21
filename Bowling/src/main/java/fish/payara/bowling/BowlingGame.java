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
        
        for (int i = 0; i < frames.size(); ++i) {
            Frame frame = frames.get(i);
            score += frame.getTotalPins();
            
            if (frame.isSpare()) {
                if (i < frames.size() - 1) {
                    score += frames.get(i + 1).roll1();
                }
                else {
                    // Final round included already as part of total pins.
                }
            }
            
            if (frame.isStrike()) {
                if (i < frames.size() - 1) {
                    Frame nextFrame = frames.get(i + 1);
                    score += nextFrame.roll1();
                    if (nextFrame.roll2().isPresent()) {
                        score += nextFrame.roll2().get();
                    }
                    else if (i < frames.size() - 2) {
                        Frame nextNextFrame = frames.get(i + 2);
                        score += nextNextFrame.roll1();
                    }
                }
            }
        }
        
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
