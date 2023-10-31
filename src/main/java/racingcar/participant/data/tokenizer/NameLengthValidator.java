package racingcar.participant.data.tokenizer;

public class NameLengthValidator implements Validator {

    private static final int MIN_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = String.format("사용자 이름은 %d 이하여야합니다.", MIN_NAME_LENGTH);

    @Override
    public void validate(String name) {
        if (name.length() > MIN_NAME_LENGTH)
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
    }
}
