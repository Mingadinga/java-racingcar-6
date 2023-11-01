package racingcar.racingGame.gameFlow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.racingGame.move.MoveAmountSelectorByRandom;

public class MoveAmountSelectorByRandomTest {
    private static final Long USER_ID = 1L;
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int BOUNDARY = 4;

    @Test
    public void 뽑은_숫자가_4이상이면_움직임() {
        for (int i=BOUNDARY;i<=MAX;i++) {
            int finalI = i;
            int moveAmount = new MoveAmountSelectorByRandom(() -> finalI).select(USER_ID);
            assertEquals(moveAmount, 1);
        }
    }

    @Test
    public void 뽑은_숫자가_4미만이면_못_움직임() {
        for (int i=MIN;i<BOUNDARY;i++) {
            int finalI = i;
            int moveAmount = new MoveAmountSelectorByRandom(() -> finalI).select(USER_ID);
            assertEquals(moveAmount, 0);
        }
    }

}
