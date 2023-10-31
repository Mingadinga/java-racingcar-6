package racingcar.participant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.participant.data.tokenizer.ParticipantNameCommaTokenizer;
import racingcar.participant.data.tokenizer.Tokenizer;

public class ParticipantNameCommaTokenizerTest {
    Tokenizer commaTokenizer = new ParticipantNameCommaTokenizer();

    @Test
    public void 토큰_여러개_입력() {
        String input = "apple,banana,cherry";
        List<String> tokens = commaTokenizer.tokenize(input);
        assertEquals(3, tokens.size());
        assertEquals("apple", tokens.get(0));
        assertEquals("banana", tokens.get(1));
        assertEquals("cherry", tokens.get(2));
    }

    @Test
    public void 토큰_여러개_입력시_공백_포함_가능() {
        String input = "apple, banana, cherry";
        List<String> tokens = commaTokenizer.tokenize(input);
        assertEquals(3, tokens.size());
        assertEquals("apple", tokens.get(0));
        assertEquals("banana", tokens.get(1));
        assertEquals("cherry", tokens.get(2));
    }

    @Test
    public void 토큰_하나만_입력() {
        String input = "apple";
        List<String> tokens = commaTokenizer.tokenize(input);
        assertEquals(1, tokens.size());
        assertEquals("apple", tokens.get(0));
    }


    @Test
    public void 빈_문자열_토큰화_시도시_예외() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> commaTokenizer.tokenize(input));
    }

    @Test
    public void testTokenizeWithException() {
        String input = "apple;banana;cherry";
        assertThrows(IllegalArgumentException.class, () -> commaTokenizer.tokenize(input));
    }
}
