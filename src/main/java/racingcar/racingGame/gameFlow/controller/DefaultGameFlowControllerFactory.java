package racingcar.racingGame.gameFlow.controller;

import racingcar.participant.controller.ParticipantController;
import racingcar.racingGame.move.DefaultMoveManagerFactory;
import racingcar.racingGame.move.MoveManagerFactory;
import racingcar.racingGame.gameFlow.view.GameCountInputComponent;
import racingcar.racingGame.gameFlow.view.OutputComponentBeforeInputGameCount;

public class DefaultGameFlowControllerFactory implements GameFlowControllerFactory {

    private final ParticipantController participantController;
    private final MoveManagerFactory moveManagerFactory;

    public DefaultGameFlowControllerFactory(ParticipantController participantController) {
        this.participantController = participantController;
        this.moveManagerFactory = new DefaultMoveManagerFactory(participantController);
    }


    @Override
    public GameFlowController get() {
        return new GameFlowControllerImpl(
                new OutputComponentBeforeInputGameCount(),
                new GameCountInputComponent(),
                moveManagerFactory.get(),
                participantController);
    }

}
