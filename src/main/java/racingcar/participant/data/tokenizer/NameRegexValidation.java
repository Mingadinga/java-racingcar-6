package racingcar.participant.data.tokenizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameRegexValidation implements Validator {

    /**
     * 사용자 이름 요구사항 - 구글 문서 약간 변형
     * <a href="https://support.google.com/mail/answer/9211434?hl=ko">...</a>
     * 사용자 이름에 영문자(a~z), 숫자(0~9), 마침표(.)를 포함할 수 있습니다.
     * 사용자 이름에 앰퍼샌드(&), 등호(=), 밑줄(_), 아포스트로피('), 대시(-), 더하기 기호(+), 쉼표(,), 괄호(<, >)를 포함할 수 없습니다.
     * 사용자 이름은 영문자로 시작할 수 있고, 영문자와 숫자로 끝낼 수 있습니다.
     */

    private static final String NAME_REGEX = "[a-zA-Z]||[a-zA-Z][a-zA-Z0-9.]*[a-zA-Z0-9]+$";
    private static final String NAME_REGEX_EXCEPTION_MESSAGE = "사용자 이름에 허용되지 않은 문자열이 포함되어있습니다.";

    @Override
    public void validate(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) throw new IllegalArgumentException(NAME_REGEX_EXCEPTION_MESSAGE);
    }
}
