package racingcar.participant.data.tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public abstract class CommaTokenizer implements Tokenizer {
    private static final String COMMA = ",";

    @Override
    public List<String> tokenize(String input) {
        StringValidator.isNotEmpty(input);

        StringTokenizer st = new StringTokenizer(input, COMMA);
        List<String> tokens = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken().trim();
            checkIsDataValidate(token);
            tokens.add(token);
        }

        return tokens;
    }

    abstract void checkIsDataValidate(String token);

    static class StringValidator {
        private static final String EMPTY_INPUT_EXCEPTION_MESSAGE = "빈 입력 문자열입니다.";

        public static String isNotEmpty(String data) {
            if (data == null || data.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION_MESSAGE);
            }
            return data;
        }
    }
}