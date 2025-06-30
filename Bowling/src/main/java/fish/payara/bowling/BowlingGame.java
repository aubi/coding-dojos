package fish.payara.bowling;

public class BowlingGame {

    private Frame[] frames = new Frame[10];
    // aaray for turns
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        if (currentRoll % 2 == 0) {
            
        }
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int calcTotalScore() {
        int score = 0;
        // collect the score for each frame
        // add the score for each frame to rolls
        //totalScore = total of rolls
        for (int i = 0; i < currentRoll; i++) {
            if (currentRoll % 2 == 0) {
                score += rolls[i];
            }
            score += rolls[i];
        }
        return score;
    }
}
