package racingcar.participant.data.tokenizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParticipantNameCommaTokenizer extends CommaTokenizer {

    private static final String NAME_REGEX = "^(?!\\.)[a-zA-Z0-9.-]+[a-zA-Z0-9.-]*$";
    private static final String NAME_REGEX_EXCEPTION_MESSAGE = "사용자 이름에 허용되지 않은 문자열이 포함되어있습니다.";

    private static final int MIN_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = String.format("사용자 이름은 %d 이하여야합니다.", MIN_NAME_LENGTH);


    @Override
    void checkIsDataValidate(String token) {
        checkNameCondition(token);
        checkNameLength(token);
    }

    private static void checkNameCondition(String token) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(token);
        if (!matcher.matches()) throw new IllegalArgumentException(NAME_REGEX_EXCEPTION_MESSAGE);
    }

    private static void checkNameLength(String name) {
        if (name.length() > MIN_NAME_LENGTH) throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
    }
}