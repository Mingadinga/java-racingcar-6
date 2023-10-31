package racingcar.participant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.participant.data.dto.ParticipantSaveRequestDto;
import racingcar.participant.data.dto.ParticipantSaveRequestDtoResolver;
import racingcar.participant.data.dto.ParticipantSaveRequestDtoResolverByName;

class ParticipantSaveRequestDtoResolverTest {

    ParticipantSaveRequestDtoResolver resolver = new ParticipantSaveRequestDtoResolverByName();

    @Test
    public void 이름정보만_있을때_RequestDto_변환() {
        ParticipantSaveRequestDto tobyRequestDto = resolver.resolve("toby");
        assertEquals(tobyRequestDto.getName(), "toby");
    }

}