package racingcar.participant.data.dto;

import racingcar.participant.domain.Participant;

public class ParticipantSaveRequestDto {
    private final String name;

    public ParticipantSaveRequestDto(String name) {
        this.name = name;
    }

    public Participant of() {
        return new Participant(name);
    }

    public String getName() {
        return name;
    }
}
