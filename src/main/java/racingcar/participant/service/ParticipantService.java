package racingcar.participant.service;

import java.util.List;
import racingcar.participant.data.dto.ParticipantSaveRequestDto;

public interface ParticipantService {
    void register(List<ParticipantSaveRequestDto> requestDtoList);
}
