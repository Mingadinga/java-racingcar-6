package racingcar.racingGame.gameFlow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import racingcar.racingGame.gameFlow.service.move.MoveAmountSelectorByRandom;
import racingcar.racingGame.gameFlow.service.move.MoveMangerImpl;

public class MoveManagerTest {

    private static final int MOVE_AMOUNT = 1;

    @Test
    public void 한번_이동후_결과를_Map으로_반환() {
        MoveMangerImpl movingManager = new MoveMangerImpl(new MoveAmountSelectorByRandom(() -> 5));
        movingManager.setMoveParticipantSet(Set.of(1L, 2L, 3L));

        Map<Long, Integer> result = movingManager.move();

        assertEquals(result.get(1L), MOVE_AMOUNT);
        assertEquals(result.get(2L), MOVE_AMOUNT);
        assertEquals(result.get(3L), MOVE_AMOUNT);
    }

}
