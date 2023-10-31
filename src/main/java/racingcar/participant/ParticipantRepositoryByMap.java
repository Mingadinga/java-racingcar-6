package racingcar.participant;

import java.util.HashMap;
import java.util.Map;

public class ParticipantRepositoryByMap implements ParticipantRepository {

    Map<Long, Participant> repository = new HashMap();

    @Override
    public void save(Participant participant) {
        repository.put(participant.getId(), participant);
    }

    @Override
    public Participant find(Long id) {
        return repository.get(id);
    }

}
