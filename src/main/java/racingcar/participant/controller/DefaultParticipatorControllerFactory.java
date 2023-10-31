package racingcar.participant.controller;

import java.util.List;
import racingcar.participant.data.dto.ParticipantSaveRequestDtoResolverByName;
import racingcar.participant.data.tokenizer.NameLengthValidator;
import racingcar.participant.data.tokenizer.NameRegexValidation;
import racingcar.participant.data.tokenizer.ParticipantNameCommaTokenizer;
import racingcar.participant.repository.ParticipantRepositoryByMap;
import racingcar.participant.service.ParticipantServiceImpl;
import racingcar.participant.view.OutputComponentBeforeInputParticipatorInfo;
import racingcar.participant.view.ParticipatorNameInputComponent;

public class DefaultParticipatorControllerFactory implements ParticipatorControllerFactory {

    @Override
    public ParticipatorController get() {
        return new ParticipatorControllerImpl(
                new OutputComponentBeforeInputParticipatorInfo(),
                new ParticipatorNameInputComponent(),
                new ParticipantNameCommaTokenizer(List.of(new NameLengthValidator(), new NameRegexValidation())),
                new ParticipantSaveRequestDtoResolverByName(),
                new ParticipantServiceImpl(new ParticipantRepositoryByMap())
        );
    }
    
}
