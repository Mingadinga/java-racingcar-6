package racingcar.racingGame.result;

public class DefaultMoveResultManagerFactory implements MoveResultManagerFactory {
    @Override
    public MoveResultManager get() {
        return new MoveResultManagerImpl(new MoveResultRepositoryImpl());
    }
}
