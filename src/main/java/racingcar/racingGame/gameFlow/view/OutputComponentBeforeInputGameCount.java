package racingcar.racingGame.gameFlow.view;

import racingcar.view.ConsoleOutputComponent;

public class OutputComponentBeforeInputGameCount extends ConsoleOutputComponent {

    private final static String MESSAGE = "시도할 회수는 몇회인가요?";

    @Override
    protected String getMessage() {
        return MESSAGE;
    }
}
