package racingcar.participant.service;

import java.util.List;
import java.util.Map;
import racingcar.participant.data.dto.ParticipantSaveRequestDto;
import racingcar.participant.domain.Participant;
import racingcar.participant.repository.ParticipantRepository;

public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;

    public ParticipantServiceImpl(ParticipantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(List<ParticipantSaveRequestDto> requestDtoList) {
        requestDtoList.stream().map(ParticipantSaveRequestDto::of)
                .forEach(participant -> repository.save(participant));
    }

    @Override
    public Map<Long, Participant> getParticipants() {
        return repository.findAll();
    }
}
