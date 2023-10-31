package racingcar.participant.view;

import racingcar.view.ConsoleOutputComponent;

public class OutputComponentBeforeInputParticipatorInfo extends ConsoleOutputComponent {
    private final static String MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    @Override
    protected String getMessage() {
        return MESSAGE;
    }
}
