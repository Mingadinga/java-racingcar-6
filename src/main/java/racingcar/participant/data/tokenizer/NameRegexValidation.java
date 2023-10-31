package racingcar.participant.data.tokenizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameRegexValidation implements Validator {

    private static final String NAME_REGEX = "^(?!\\.)[a-zA-Z0-9.-]+[a-zA-Z0-9.-]*$";
    private static final String NAME_REGEX_EXCEPTION_MESSAGE = "사용자 이름에 허용되지 않은 문자열이 포함되어있습니다.";

    @Override
    public void validate(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) throw new IllegalArgumentException(NAME_REGEX_EXCEPTION_MESSAGE);
    }
}
