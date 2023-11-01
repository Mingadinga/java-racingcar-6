package racingcar;

import racingcar.participant.controller.DefaultParticipantControllerFactory;
import racingcar.participant.controller.ParticipantController;
import racingcar.participant.controller.ParticipantControllerFactory;
import racingcar.racingGame.gameFlow.controller.DefaultGameFlowControllerFactory;
import racingcar.racingGame.gameFlow.controller.GameFlowController;
import racingcar.racingGame.gameFlow.controller.GameFlowControllerFactory;

public class Application {
    private final static ParticipantControllerFactory participatorControllerFactory = new DefaultParticipantControllerFactory();
    private final static ParticipantController participantController = participatorControllerFactory.get();

    private final static GameFlowControllerFactory gameFlowControllerFactory = new DefaultGameFlowControllerFactory(
            participantController);
    private final static GameFlowController gameFlowController = gameFlowControllerFactory.get();

    public static void main(String[] args) {
        participantController.save();
        gameFlowController.initializeSettings();
        gameFlowController.start();

    }
}
