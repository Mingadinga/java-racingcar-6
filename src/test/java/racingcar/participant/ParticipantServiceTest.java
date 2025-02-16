package racingcar.participant;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import racingcar.participant.data.dto.ParticipantSaveRequestDto;
import racingcar.participant.domain.Participant;
import racingcar.participant.repository.ParticipantRepository;
import racingcar.participant.repository.ParticipantRepositoryByMap;
import racingcar.participant.service.ParticipantService;
import racingcar.participant.service.ParticipantServiceImpl;

class ParticipantServiceTest {

    ParticipantRepository repository = new ParticipantRepositoryByMap();
    ParticipantService service = new ParticipantServiceImpl(repository);

    @Test
    public void DTO로_Participant_저장() {
        List<ParticipantSaveRequestDto> requestDtoList = new ArrayList<>();
        requestDtoList.add(new ParticipantSaveRequestDto("toby"));
        requestDtoList.add(new ParticipantSaveRequestDto("woni"));

        service.register(requestDtoList);

        Optional<Participant> toby = repository.findByName("toby");
        assertTrue(toby.isPresent());
        Optional<Participant> woni = repository.findByName("woni");
        assertTrue(woni.isPresent());
    }
}