package racingcar.participant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.participant.data.tokenizer.NameLengthValidator;
import racingcar.participant.data.tokenizer.NameRegexValidation;
import racingcar.participant.data.tokenizer.ParticipantNameCommaTokenizer;
import racingcar.participant.data.tokenizer.Tokenizer;

public class ParticipantNameCommaTokenizerTest {
    Tokenizer commaTokenizer = new ParticipantNameCommaTokenizer(List.of(new NameLengthValidator(), new NameRegexValidation()));

    @Test
    public void 토큰_여러개_입력() {
        String input = "pobi,woni,jun";
        List<String> tokens = commaTokenizer.tokenize(input);
        assertEquals(3, tokens.size());
        assertEquals("pobi", tokens.get(0));
        assertEquals("woni", tokens.get(1));
        assertEquals("jun", tokens.get(2));
    }

    @Test
    public void 토큰_여러개_입력시_공백_포함_가능() {
        String input = "pobi, woni, jun";
        List<String> tokens = commaTokenizer.tokenize(input);
        assertEquals(3, tokens.size());
        assertEquals("pobi", tokens.get(0));
        assertEquals("woni", tokens.get(1));
        assertEquals("jun", tokens.get(2));
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
    public void 쉼표_외에_다른_구분자_사용시_실패() {
        String input = "pobi;woni;jun";
        assertThrows(IllegalArgumentException.class, () -> commaTokenizer.tokenize(input));
    }


}
