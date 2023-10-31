package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class ConsoleInputComponent implements InputComponent {

    @Override
    public String input() {
        String input = Console.readLine();
        validate(input);
        Console.close();
        return input;
    }

    protected abstract void validate(String input);
}
