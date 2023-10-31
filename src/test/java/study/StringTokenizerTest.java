package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

public class StringTokenizerTest {

    @Test
    public void 공백없는문자열_토큰화() {
        String input = "apple,banana,cherry";
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        int tokenCount = tokenizer.countTokens();

        assertEquals(3, tokenCount);

        String token1 = tokenizer.nextToken().trim();
        String token2 = tokenizer.nextToken().trim();
        String token3 = tokenizer.nextToken().trim();

        assertEquals("apple", token1);
        assertEquals("banana", token2);
        assertEquals("cherry", token3);
    }

    @Test
    public void 공백있는문자열_토큰화시_공백제거_필요() {
        String input = "apple, banana, cherry";
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        int tokenCount = tokenizer.countTokens();

        assertEquals(3, tokenCount);

        String token1 = tokenizer.nextToken().trim();
        String token2 = tokenizer.nextToken().trim();
        String token3 = tokenizer.nextToken().trim();

        assertEquals("apple", token1);
        assertEquals("banana", token2);
        assertEquals("cherry", token3);
    }

    @Test
    public void 빈_문자열_토큰화() {
        String input = "";
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        int tokenCount = tokenizer.countTokens();

        assertEquals(0, tokenCount);
        assertThrows(NoSuchElementException.class, tokenizer::nextToken);
    }

    @Test
    public void 구분자가_포함되지_않은_문자열_토큰화() {
        String input = "apple;banana;cherry";
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        int tokenCount = tokenizer.countTokens();

        assertEquals(1, tokenCount);
        assertEquals("apple;banana;cherry", tokenizer.nextToken());
    }

}
