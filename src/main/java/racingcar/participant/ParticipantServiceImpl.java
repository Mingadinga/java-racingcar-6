package racingcar.participant;

import java.util.List;

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
