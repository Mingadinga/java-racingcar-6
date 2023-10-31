package racingcar.participant;

public class ParticipantSaveRequestDto {
    private final String name;

    public ParticipantSaveRequestDto(String name) {
        this.name = name;
    }

    public Participant of() {
        return new Participant(name);
    }
}
