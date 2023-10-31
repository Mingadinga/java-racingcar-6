package racingcar.view;

abstract public class ConsoleOutputComponent implements OutputComponent {
    @Override
    public void print() {
        System.out.println(getMessage());
    }

    protected abstract String getMessage();
}
