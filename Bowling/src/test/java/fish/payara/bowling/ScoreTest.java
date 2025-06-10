package fish.payara.bowling;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 33 33 33 33 33 33 33 33 33 33 (20 rolls: 3 every roll) = 20 frames * 3 points = 60 * X X X X X X X X X X X X (12
 * rolls: 12 strikes) = 10 frames * 30 points = 300 X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30
 * points = 300 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90 * 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150
 *
 */
public class ScoreTest {

    @Test
    public void testStrikeScoreCalculation() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 10 + 2; i++) {
            game.roll(10);
        }
        // FIXME: implement strikes and spares
        assertEquals(300, game.calcTotalScore());
    }

    @Test
    public void testScoreCalculation3Pins() {
        BowlingGame game = new BowlingGame();
        // test for when there is 3 pins for each roll
        for (int i = 0; i < 2 * 10; i++) {
            game.roll(3);
        }
        assertEquals(10 * 2 * 3, game.calcTotalScore());
    }
}
