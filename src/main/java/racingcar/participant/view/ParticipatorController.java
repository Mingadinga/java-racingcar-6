package racingcar.participant.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.participant.data.dto.ParticipantSaveRequestDto;
import racingcar.participant.data.dto.ParticipantSaveRequestDtoResolver;
import racingcar.participant.data.dto.ParticipantSaveRequestDtoResolverByName;
import racingcar.participant.data.tokenizer.NameLengthValidator;
import racingcar.participant.data.tokenizer.NameRegexValidation;
import racingcar.participant.data.tokenizer.ParticipantNameCommaTokenizer;
import racingcar.participant.data.tokenizer.Tokenizer;
import racingcar.participant.repository.ParticipantRepository;
import racingcar.participant.repository.ParticipantRepositoryByMap;
import racingcar.participant.service.ParticipantService;
import racingcar.participant.service.ParticipantServiceImpl;
import racingcar.view.InputComponent;
import racingcar.view.OutputComponent;

public class ParticipatorController {

    public static void save() {
        OutputComponent outputComponent = new OutputComponentBeforeInputParticipatorInfo(); // console
        InputComponent inputComponent = new ParticipatorNameInputComponent(); // console

        outputComponent.print();
        String inputInformation = inputComponent.input();
        Tokenizer tokenizer = new ParticipantNameCommaTokenizer(List.of(new NameLengthValidator(), new NameRegexValidation()));
        List<String> informationList = tokenizer.tokenize(inputInformation);

        ParticipantSaveRequestDtoResolver resolver = new ParticipantSaveRequestDtoResolverByName();
        List<ParticipantSaveRequestDto> requestDtos = informationList.stream().map(resolver::resolve)
                .collect(Collectors.toList());

        ParticipantRepository repository = new ParticipantRepositoryByMap();
        ParticipantService service = new ParticipantServiceImpl(repository);
        service.register(requestDtos);

    }

}
