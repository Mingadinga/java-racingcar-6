package racingcar.participant.data.tokenizer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParticipantNameCommaTokenizer extends CommaTokenizer {

    private final List<Validator> validatorList;

    public ParticipantNameCommaTokenizer(List<Validator> validatorList) {
        this.validatorList = validatorList;
    }

    @Override
    void checkIsDataValidate(String token) {
        validatorList.forEach(validator -> validator.validate(token));
    }

}