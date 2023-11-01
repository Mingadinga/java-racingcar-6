package racingcar.racingGame.gameFlow;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.participant.controller.ParticipantController;
import racingcar.racingGame.gameFlow.domain.Range;
import racingcar.racingGame.gameFlow.domain.RangedNumber;
import racingcar.racingGame.gameFlow.service.GameFlowManager;
import racingcar.racingGame.gameFlow.service.GameFlowManagerByCount;
import racingcar.racingGame.move.DefaultMoveManagerFactory;
import racingcar.racingGame.move.MoveManager;
import racingcar.racingGame.result.DefaultMoveResultManagerFactory;
import racingcar.racingGame.result.MoveResultManager;

class GameFlowManagerByCountTest {

    private static Range range;
    private static RangedNumber VALID_GAME_COUNT;
    private static RangedNumber UNABLE_TO_CONTINUE_GAME_COUNT;
    private static MoveManager moveManager;
    private static MoveResultManager moveResultManager;

    @BeforeEach
    public void before() {
        range = new Range(0, 5);
        VALID_GAME_COUNT = range.of(5);
        UNABLE_TO_CONTINUE_GAME_COUNT = range.of(0);
        moveManager = new DefaultMoveManagerFactory(new ParticipantController() {
            @Override
            public void save() {

            }

            @Override
            public Set<Long> getParticipants() {
                return Set.of(1L, 2L, 3L);
            }
        }).get();
        moveResultManager = new DefaultMoveResultManagerFactory().get();
    }


    @Test
    public void 플레이횟수_남았다면_진행가능() {
        GameFlowManager gameFlowManager = new GameFlowManagerByCount(VALID_GAME_COUNT, moveManager, moveResultManager);
        assertTrue(gameFlowManager.isContinuable());
    }

    @Test
    public void 플레이횟수_남지않았다면_진행불가() {
        GameFlowManager gameFlowManager = new GameFlowManagerByCount(UNABLE_TO_CONTINUE_GAME_COUNT, moveManager,
                moveResultManager);
        assertFalse(gameFlowManager.isContinuable());
    }

    @Test
    public void 플레이가능상태_진행가능() {
        GameFlowManager gameFlowManager = new GameFlowManagerByCount(VALID_GAME_COUNT, moveManager, moveResultManager);
        gameFlowManager.doContinue();
    }

    @Test
    public void 플레이불가능상태_진행불가능() {
        GameFlowManager gameFlowManager = new GameFlowManagerByCount(UNABLE_TO_CONTINUE_GAME_COUNT, moveManager,
                moveResultManager);
        assertThrows(IllegalStateException.class, () -> gameFlowManager.doContinue());
    }

    @Test
    public void 플레이가능상태에서_진행시_count_감소() {
        GameFlowManagerByCount gameFlowManager = new GameFlowManagerByCount(VALID_GAME_COUNT, moveManager,
                moveResultManager);
        int count = gameFlowManager.getCount().getValue();

        gameFlowManager.doContinue();
        assertEquals(gameFlowManager.getCount().getValue(), count-1);
    }

    @Test
    public void count만큼_진행시_플레이불가상태로_바뀜() {
        GameFlowManagerByCount gameFlowManager = new GameFlowManagerByCount(VALID_GAME_COUNT, moveManager,
                moveResultManager);
        int count = gameFlowManager.getCount().getValue();
        for (int i=0;i<count;i++) {
            gameFlowManager.doContinue();
        }
        assertFalse(gameFlowManager.isContinuable());
        assertEquals(gameFlowManager.getCount().getValue(), UNABLE_TO_CONTINUE_GAME_COUNT.getValue());
    }


}