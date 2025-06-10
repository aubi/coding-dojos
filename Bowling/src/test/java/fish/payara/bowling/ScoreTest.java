package fish.payara.bowling;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
 * 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
 * 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150
 *
 */
public class ScoreTest {

    @Test
    public void testStrikeScoreCalculation() {
        BowlingGame game = new BowlingGame();

        for()

        game.totalScore();
        assertEquals(300, game.totalScore());
    }

    @Test
    public void testScoreCalculation() {
        BowlingGame game = new BowlingGame();
        // test for when there is 3 pins for each roll
        int[] roll = new int[21];

        for()

        for(int i = 0; i < 10; i++) {

        }
    }
}
