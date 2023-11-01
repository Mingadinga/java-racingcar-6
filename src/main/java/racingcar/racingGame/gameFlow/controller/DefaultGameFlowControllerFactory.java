package racingcar.racingGame.gameFlow.controller;

import racingcar.participant.controller.ParticipantController;
import racingcar.racingGame.move.DefaultMoveManagerFactory;
import racingcar.racingGame.move.MoveManagerFactory;
import racingcar.racingGame.gameFlow.view.GameCountInputComponent;
import racingcar.racingGame.gameFlow.view.OutputComponentBeforeInputGameCount;
import racingcar.racingGame.result.DefaultMoveResultManagerFactory;
import racingcar.racingGame.result.MoveResultManagerFactory;

public class DefaultGameFlowControllerFactory implements GameFlowControllerFactory {

    private final ParticipantController participantController;
    private final MoveManagerFactory moveManagerFactory;
    private final MoveResultManagerFactory moveResultManagerFactory;

    public DefaultGameFlowControllerFactory(ParticipantController participantController) {
        this.participantController = participantController;
        this.moveManagerFactory = new DefaultMoveManagerFactory(participantController);
        this.moveResultManagerFactory = new DefaultMoveResultManagerFactory();
    }


    @Override
    public GameFlowController get() {
        return new GameFlowControllerImpl(
                new OutputComponentBeforeInputGameCount(),
                new GameCountInputComponent(),
                moveManagerFactory.get(),
                moveResultManagerFactory.get(),
                participantController);
    }

}
