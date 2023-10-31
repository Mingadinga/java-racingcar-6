package racingcar.participant;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.participant.data.tokenizer.NameLengthValidator;
import racingcar.participant.data.tokenizer.Validator;

public class NameLengthValidatorTest {

    Validator validator = new NameLengthValidator();

    @Test
    public void 다섯글자_이하_성공() {
        String validName = "user";
        validator.validate(validName);
    }

    @Test
    public void 다섯글자_초과_실패() {
        String inValidName = "userlonglong";
        assertThrows(IllegalArgumentException.class, () -> validator.validate(inValidName));
    }
}
