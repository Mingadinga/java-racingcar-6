package racingcar.participant;

import java.util.List;

public class ParticipantService {

    ParticipantRepository repository;

    public void register(List<ParticipantSaveRequestDto> requestDtoList) {
        requestDtoList.stream().map(ParticipantSaveRequestDto::of)
                .forEach(participant -> repository.save(participant));
    }
}
