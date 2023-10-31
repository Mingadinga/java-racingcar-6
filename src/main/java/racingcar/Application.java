package racingcar;

import racingcar.participant.controller.DefaultParticipantControllerFactory;
import racingcar.participant.controller.ParticipantControllerFactory;

public class Application {
    private final static ParticipantControllerFactory participatorControllerFactory = new DefaultParticipantControllerFactory();
    public static void main(String[] args) {
       participatorControllerFactory.get().save();

    }
}
