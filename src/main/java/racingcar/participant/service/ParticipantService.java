package racingcar.participant.service;

import java.util.List;
import java.util.Map;
import racingcar.participant.data.dto.ParticipantSaveRequestDto;
import racingcar.participant.domain.Participant;

public interface ParticipantService {
    void register(List<ParticipantSaveRequestDto> requestDtoList);
    Map<Long, Participant> getParticipants();
}
