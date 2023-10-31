package racingcar.participant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParticipantRepositoryTest {

    ParticipantRepository repository = new ParticipantRepositoryByMap();
    Participant participant = new Participant(1L, "toby");

    @Test
    public void Participant_저장() {
        repository.save(participant);
        Participant foundParticipant = repository.find(1L);
        assertEquals(foundParticipant, participant);
    }

}