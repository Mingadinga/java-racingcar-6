package racingcar.participant.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import racingcar.participant.domain.Participant;

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

    @Override
    public Optional<Participant> findByName(String name) {
        return repository.values().stream().filter(participant -> participant.getName().contentEquals(name)).findFirst();
    }

    @Override
    public Map<Long, Participant> findAll() {
        return repository;
    }

}
