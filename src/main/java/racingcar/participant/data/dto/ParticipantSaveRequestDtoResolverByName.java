package racingcar.participant.data.dto;

public class ParticipantSaveRequestDtoResolverByName implements ParticipantSaveRequestDtoResolver {
    public ParticipantSaveRequestDto resolve(String name) {
        return new ParticipantSaveRequestDto(name);
    }
}
