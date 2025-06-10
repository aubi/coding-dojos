package fish.payara.bowling;

public class BowlingGame {

    // aaray for turns
    private int[] rolls = new int[21];
    private int currentRoll = 0;
    private int frames = 10;
    private int score = 0;

    public int totalScore() {
        // collect the score for each frame
        // add the score for each frame to rolls
        //totalScore = total of rolls
        for(int i = 0; i < frames; i++) {
            score += rolls[currentRoll];
        }
        return score;
    }
}
