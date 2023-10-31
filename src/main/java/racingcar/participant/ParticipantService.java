package racingcar.participant;

import java.util.List;

public interface ParticipantService {
    void register(List<ParticipantSaveRequestDto> requestDtoList);
}
