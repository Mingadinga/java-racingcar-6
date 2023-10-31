package racingcar.participant;

public class ParticipantSaveRequestDto {
    private final String name;

    public ParticipantSaveRequestDto(String name) {
        this.name = name;
    }

    public Participant of() {
        // todo : sequence 객체 필요
        return new Participant(1L, name);
    }
}
