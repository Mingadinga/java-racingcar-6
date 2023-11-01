package racingcar.participant.controller;

import java.util.Set;

public interface ParticipantController {
    void save();
    Set<Long> getParticipants();
}
