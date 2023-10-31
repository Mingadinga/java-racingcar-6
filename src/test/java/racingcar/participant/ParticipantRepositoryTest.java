package racingcar.participant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParticipantRepositoryTest {

    ParticipantRepository repository = new ParticipantRepositoryByMap();
    Participant participant = new Participant("toby");

    @Test
    public void Participant_저장과_조회() {
        repository.save(participant);
        Participant foundParticipant = repository.find(participant.getId());
        assertEquals(foundParticipant.getId(), participant.getId());
    }
}