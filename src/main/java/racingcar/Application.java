package racingcar;

import racingcar.participant.controller.DefaultParticipatorControllerFactory;
import racingcar.participant.controller.ParticipatorControllerFactory;

public class Application {
    private final static ParticipatorControllerFactory participatorControllerFactory = new DefaultParticipatorControllerFactory();
    public static void main(String[] args) {
       participatorControllerFactory.get().save();

    }
}
