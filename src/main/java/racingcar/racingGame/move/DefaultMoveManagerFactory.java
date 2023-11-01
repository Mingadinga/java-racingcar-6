package racingcar.racingGame.move;

import racingcar.participant.controller.ParticipantController;

public class DefaultMoveManagerFactory implements MoveManagerFactory {
    private final ParticipantController participantController;

    public DefaultMoveManagerFactory(ParticipantController participantController) {
        this.participantController = participantController;
    }

    @Override
    public MoveManager get() {
        return new MoveMangerImpl(new MoveAmountSelectorByRandom(new RandomPickerByRandoms()), participantController.getParticipants());
    }
}
