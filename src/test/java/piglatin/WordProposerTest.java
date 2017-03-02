package piglatin;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordProposerTest {

    private final List<String> alternatives = Arrays.asList(
            "pig", "latin", "banana", "cheers", "eat", "wordMissing");
    WordProposer wordProposer = new WordProposer(alternatives);

    @Test
    public void proposeWord1() {
        assertEquals("pig", wordProposer.proposeWord(0));
    }

    @Test
    public void proposeWord2() {
        assertEquals("latin", wordProposer.proposeWord(1));
    }

    @Test
    public void proposeWord3() {
        assertEquals("banana", wordProposer.proposeWord(2));
    }

    @Test
    public void proposeWord4() {
        assertEquals("cheers", wordProposer.proposeWord(3));
    }

    @Test
    public void proposeWord5() {
        assertEquals("eat", wordProposer.proposeWord(4));
    }

}
