package racingcar.racingGame.gameFlow.controller;

import racingcar.racingGame.gameFlow.service.move.DefaultMoveManagerFactory;
import racingcar.racingGame.gameFlow.service.move.MoveManagerFactory;
import racingcar.racingGame.gameFlow.view.GameCountInputComponent;
import racingcar.racingGame.gameFlow.view.OutputComponentBeforeInputGameCount;

public class DefaultGameFlowControllerFactory implements GameFlowControllerFactory {

    private static MoveManagerFactory moveManagerFactory = new DefaultMoveManagerFactory();

    private final static GameFlowController INSTANCE = new GameFlowControllerImpl(
            new OutputComponentBeforeInputGameCount(),
            new GameCountInputComponent(),
            moveManagerFactory.get()
    );

    @Override
    public GameFlowController get() {
        return INSTANCE;
    }

}
