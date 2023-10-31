package racingcar.participant;

import java.util.Optional;

public interface ParticipantRepository {
    void save(Participant participant);
    Optional<Participant> find(Long id);
}
