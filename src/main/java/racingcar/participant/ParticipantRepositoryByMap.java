package racingcar.participant;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParticipantRepositoryByMap implements ParticipantRepository {

    Map<Long, Participant> repository = new HashMap<>();

    @Override
    public void save(Participant participant) {
        repository.put(participant.getId(), participant);
    }

    @Override
    public Optional<Participant> find(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

}
