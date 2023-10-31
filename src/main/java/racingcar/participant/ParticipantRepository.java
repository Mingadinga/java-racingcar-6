package racingcar.participant;

public interface ParticipantRepository {
    void save(Participant participant);
    Participant find(Long id);
}
