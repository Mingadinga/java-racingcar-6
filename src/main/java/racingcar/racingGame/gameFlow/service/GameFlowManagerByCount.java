package racingcar.racingGame.gameFlow.service;

import racingcar.racingGame.gameFlow.domain.RangedNumber;
import racingcar.racingGame.move.MoveManager;
import racingcar.racingGame.result.MoveResultManager;

public class GameFlowManagerByCount implements GameFlowManager {

    private RangedNumber count;
    private final MoveManager moveManager;
    private final MoveResultManager moveResultManager;

    public GameFlowManagerByCount(RangedNumber count, MoveManager moveManager, MoveResultManager moveResultManager) {
        this.count = count;
        this.moveManager = moveManager;
        this.moveResultManager = moveResultManager;
    }

    @Override
    public boolean isContinuable() {
        return this.count.isBiggerThan(0);
    }

    @Override
    public void doContinue() {
        if (!isContinuable()) throw new IllegalStateException("플레이 가능한 횟수가 모두 소진되었습니다.");
        moveResultManager.add(moveManager.move());
        count.minus();
    }

    public RangedNumber getCount() {
        return this.count;
    }

}
