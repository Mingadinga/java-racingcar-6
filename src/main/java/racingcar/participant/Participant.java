package racingcar.participant;

public class Participant {
    private final Long id;
    private final String name;


    public Participant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
