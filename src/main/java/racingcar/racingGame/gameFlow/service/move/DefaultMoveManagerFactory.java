package racingcar.racingGame.gameFlow.service.move;

public class DefaultMoveManagerFactory implements MoveManagerFactory {
    @Override
    public MoveManager get() {
        return new MoveMangerImpl(new MoveAmountSelectorByRandom(new RandomPickerByRandoms()));
    }
}
