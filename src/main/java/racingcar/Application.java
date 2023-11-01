package racingcar;

import racingcar.participant.controller.DefaultParticipantControllerFactory;
import racingcar.participant.controller.ParticipantControllerFactory;
import racingcar.racingGame.gameFlow.controller.DefaultGameFlowControllerFactory;
import racingcar.racingGame.gameFlow.controller.GameFlowControllerFactory;

public class Application {
    private final static ParticipantControllerFactory participatorControllerFactory = new DefaultParticipantControllerFactory();
    private final static GameFlowControllerFactory gameFlowControllerFactory = new DefaultGameFlowControllerFactory();

    public static void main(String[] args) {
        participatorControllerFactory.get().save();
        gameFlowControllerFactory.get().initializeSettings();
        gameFlowControllerFactory.get().start();

    }
}
