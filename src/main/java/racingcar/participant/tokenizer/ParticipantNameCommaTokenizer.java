package racingcar.participant.tokenizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParticipantNameCommaTokenizer extends CommaTokenizer {

    private static final String nameRegex = "^(?!\\.)[a-zA-Z0-9.-]+[a-zA-Z0-9.-]*$";
    private static final String NAME_EXCEPTION_MESSAGE = "사용자 이름에 허용되지 않은 문자열이 포함되어있습니다.";

    @Override
    void checkIsDataValidate(String token) {
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(token);
        if (!matcher.matches()) throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
    }
}
