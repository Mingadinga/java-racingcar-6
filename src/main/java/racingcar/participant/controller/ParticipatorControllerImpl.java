package racingcar.participant.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.participant.data.dto.ParticipantSaveRequestDto;
import racingcar.participant.data.dto.ParticipantSaveRequestDtoResolver;
import racingcar.participant.data.tokenizer.Tokenizer;
import racingcar.participant.service.ParticipantService;
import racingcar.view.InputComponent;
import racingcar.view.OutputComponent;

public class ParticipatorControllerImpl implements ParticipatorController {

    private final OutputComponent outputComponent;
    private final InputComponent inputComponent;
    private final Tokenizer tokenizer;
    private final ParticipantSaveRequestDtoResolver resolver;
    private final ParticipantService participantService;

    public ParticipatorControllerImpl(OutputComponent outputComponent, InputComponent inputComponent,
                                      Tokenizer tokenizer, ParticipantSaveRequestDtoResolver resolver,
                                      ParticipantService participantService) {
        this.outputComponent = outputComponent;
        this.inputComponent = inputComponent;
        this.tokenizer = tokenizer;
        this.resolver = resolver;
        this.participantService = participantService;
    }

    @Override
    public void save() {
        String inputInformation = interactWithViewAndGetInput();
        List<String> tokenList = tokenizer.tokenize(inputInformation);
        participantService.register(mapInputTokenListToRequestDto(tokenList));
    }

    private String interactWithViewAndGetInput() {
        outputComponent.print();
        return inputComponent.input();
    }

    private List<ParticipantSaveRequestDto> mapInputTokenListToRequestDto(List<String> informationList) {
        return informationList.stream().map(resolver::resolve)
                .collect(Collectors.toList());
    }

}
