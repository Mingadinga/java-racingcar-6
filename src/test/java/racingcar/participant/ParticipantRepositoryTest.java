package racingcar.participant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import racingcar.participant.domain.Participant;
import racingcar.participant.repository.ParticipantRepository;
import racingcar.participant.repository.ParticipantRepositoryByMap;

class ParticipantRepositoryTest {

    ParticipantRepository repository = new ParticipantRepositoryByMap();
    Participant participant = new Participant("toby");

    @Test
    public void Participant_저장과_조회() {
        repository.save(participant);
        Optional<Participant> foundParticipant = repository.find(participant.getId());
        assertTrue(foundParticipant.isPresent());
        assertEquals(foundParticipant.get().getId(), participant.getId());
    }

    @Test
    public void 존재하지않는_Participant_조회() {
        Optional<Participant> optionalParticipant = repository.find(Long.MAX_VALUE);
        assertTrue(optionalParticipant.isEmpty());
    }
}