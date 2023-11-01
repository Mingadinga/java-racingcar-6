package racingcar.racingGame.gameFlow.service;

import racingcar.racingGame.gameFlow.domain.RangedNumber;

public class GameFlowManagerByCount implements GameFlowManager {

    private RangedNumber count;
    private final MoveManager moveManager;

    public GameFlowManagerByCount(RangedNumber count, MoveManager moveManager) {
        this.count = count;
        this.moveManager = moveManager;
    }

    @Override
    public boolean isContinuable() {
        return this.count.isBiggerThan(0);
    }

    @Override
    public void doContinue() {
        if (!isContinuable()) throw new IllegalStateException("플레이 가능한 횟수가 모두 소진되었습니다.");
        moveManager.move();
        count.minus();
    }

    public RangedNumber getCount() {
        return this.count;
    }

}
