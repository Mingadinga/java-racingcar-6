package racingcar.racingGame.gameFlow.controller;

import racingcar.racingGame.gameFlow.view.GameCountInputComponent;
import racingcar.racingGame.gameFlow.view.OutputComponentBeforeInputGameCount;

public class DefaultGameFlowControllerFactory implements GameFlowControllerFactory {

    private final static GameFlowController INSTANCE = new GameFlowControllerImpl(
            new OutputComponentBeforeInputGameCount(),
            new GameCountInputComponent(),
            () -> {} // todo
    );

    @Override
    public GameFlowController get() {
        return INSTANCE;
    }
    
}
