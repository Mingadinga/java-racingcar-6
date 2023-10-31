package study;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RegexTest {
    private static final String regex = "^(?!\\.)[a-zA-Z0-9.-]+[a-zA-Z0-9.-]*$";

    @Test
    void validUserNamesShouldMatchRegex() {
        String[] validUserNames = {
                "username",
                "user123",
                "user-name",
                "user.name",
                "user123.name",
                "user-name.123"
        };

        for (String userName : validUserNames) {
            assertTrue(userName.matches(regex));
        }
    }

    @Test
    void invalidUserNamesShouldNotMatchRegex() {
        String[] invalidUserNames = {
                "user@name",
                ".username",
                "user_name",
                "user+name",
                "user<name"
        };

        for (String userName : invalidUserNames) {
            System.out.println(userName);
            assertFalse(userName.matches(regex));
        }
    }
}
