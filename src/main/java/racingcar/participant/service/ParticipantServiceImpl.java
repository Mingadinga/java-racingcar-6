package racingcar.participant.service;

import java.util.List;
import racingcar.participant.data.ParticipantSaveRequestDto;
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
}
