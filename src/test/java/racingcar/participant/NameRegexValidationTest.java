package racingcar.participant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.participant.data.tokenizer.NameRegexValidation;
import racingcar.participant.data.tokenizer.Validator;

class NameRegexValidationTest {

    Validator validator = new NameRegexValidation();

    @Test
    public void 영문자_마침표_포함_성공() {
        String[] validUserNames = {
                "user",
                "us1r",
                "u.er",
                "u1.er"
        };

        for (String name : validUserNames) {
            validator.validate(name);
        }
    }

    @Test
    public void 영문자_하나만_성공() {
        String validUserName = "y";
        validator.validate(validUserName);
    }

    @Test
    public void 특수문자_포함시_실패() {

        String[] invalidUserNames = {
                "us&er",
                "us=er",
                "us_er",
                "us'er",
                "us-er",
                "us+er",
                "us,er",
                "us<er",
                "us>er",
        };

        for (String name : invalidUserNames) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(name));
        }
    }

    @Test
    public void 숫자나_마침표로_시작시_실패() {
        String[] invalidUserNames = {
                ".",
                "1",
                ".user",
                "1user",
        };

        for (String name : invalidUserNames) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(name));
        }
    }

    @Test
    public void 마침표로_종료시_실패() {
        String[] invalidUserNames = {
                "user.",
        };

        for (String name : invalidUserNames) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(name));
        }
    }

}