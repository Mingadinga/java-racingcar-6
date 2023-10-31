package racingcar.participant.view;

import racingcar.view.ConsoleInputComponent;

public class ParticipantNameInputComponent extends ConsoleInputComponent {

    private final static String MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    @Override
    protected void validate(String input) {

    }
}
