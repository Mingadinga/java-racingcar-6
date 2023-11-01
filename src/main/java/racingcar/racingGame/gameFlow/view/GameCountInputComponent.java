package racingcar.racingGame.gameFlow.view;

import racingcar.view.ConsoleInputComponent;

public class GameCountInputComponent extends ConsoleInputComponent {

    @Override
    protected void validate(String input) {
        checkIsNumeric(input);
    }

    private static void checkIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}