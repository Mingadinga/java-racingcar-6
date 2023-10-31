package racingcar.participant;

public class Participant {
    private final Long id;
    private final String name;


    public Participant(String name) {
        this.id = ParticipantSequence.INSTANCE.getNext();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
