package racingcar.racingGame.gameFlow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.racingGame.gameFlow.domain.Range;
import racingcar.racingGame.gameFlow.domain.RangedNumber;
import racingcar.racingGame.gameFlow.service.GameFlowManager;
import racingcar.racingGame.gameFlow.service.GameFlowManagerByCount;

class GameFlowManagerByCountTest {

    private static Range range;
    private static RangedNumber VALID_GAME_COUNT;
    private static RangedNumber UNABLE_TO_CONTINUE_GAME_COUNT;

    @BeforeEach
    public void before() {
        range = new Range(0, 5);
        VALID_GAME_COUNT = range.of(5);
        UNABLE_TO_CONTINUE_GAME_COUNT = range.of(0);
    }


    @Test
    public void 플레이횟수_남았다면_진행가능() {
        GameFlowManager gameFlowManager = new GameFlowManagerByCount(VALID_GAME_COUNT, () -> {});
        assertTrue(gameFlowManager.isContinuable());
    }

    @Test
    public void 플레이횟수_남지않았다면_진행불가() {
        GameFlowManager gameFlowManager = new GameFlowManagerByCount(UNABLE_TO_CONTINUE_GAME_COUNT, () -> {});
        assertFalse(gameFlowManager.isContinuable());
    }

    @Test
    public void 플레이가능상태_진행가능() {
        GameFlowManager gameFlowManager = new GameFlowManagerByCount(VALID_GAME_COUNT, () -> {});
        gameFlowManager.doContinue();
    }

    @Test
    public void 플레이불가능상태_진행불가능() {
        GameFlowManager gameFlowManager = new GameFlowManagerByCount(UNABLE_TO_CONTINUE_GAME_COUNT, () -> {});
        assertThrows(IllegalStateException.class, () -> gameFlowManager.doContinue());
    }

    @Test
    public void 플레이가능상태에서_진행시_count_감소() {
        GameFlowManagerByCount gameFlowManager = new GameFlowManagerByCount(VALID_GAME_COUNT, () -> {});
        int count = gameFlowManager.getCount().getValue();

        gameFlowManager.doContinue();
        assertEquals(gameFlowManager.getCount().getValue(), count-1);
    }

    @Test
    public void count만큼_진행시_플레이불가상태로_바뀜() {
        GameFlowManagerByCount gameFlowManager = new GameFlowManagerByCount(VALID_GAME_COUNT, () -> {});
        int count = gameFlowManager.getCount().getValue();
        for (int i=0;i<count;i++) {
            gameFlowManager.doContinue();
        }
        assertFalse(gameFlowManager.isContinuable());
        assertEquals(gameFlowManager.getCount().getValue(), UNABLE_TO_CONTINUE_GAME_COUNT.getValue());
    }


}