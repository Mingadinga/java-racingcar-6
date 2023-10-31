package racingcar.participant.repository;

import java.util.Optional;
import racingcar.participant.domain.Participant;

public interface ParticipantRepository {
    void save(Participant participant);
    Optional<Participant> find(Long id);

    Optional<Participant> findByName(String name);
}
