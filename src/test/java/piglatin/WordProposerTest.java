package piglatin;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordProposerTest {
    private final List<String> alternatives = Arrays.asList(
            "pig", "latin", "banana", "cheers", "eat", "wordMissing");
    private final WordProposer wordProposer = new WordProposer(alternatives);

    @Test
    public void getWord1() {
        assertEquals("pig", wordProposer.getWord(0));
    }

    @Test
    public void getWord2() {
        assertEquals("latin", wordProposer.getWord(1));
    }

    @Test
    public void getWord3() {
        assertEquals("banana", wordProposer.getWord(2));
    }

    @Test
    public void getWord4() {
        assertEquals("cheers", wordProposer.getWord(3));
    }

    @Test
    public void getWord5() {
        assertEquals("eat", wordProposer.getWord(4));
    }

    @Test
    public void proposeWord() {
        for (String alternative : alternatives) {
            assertEquals(alternative, wordProposer.proposeWord());
        }
    }

    @Test
    public void wrapAround() {
        for (String alternative : alternatives) {
            assertEquals(alternative, wordProposer.proposeWord());
        }
        assertEquals("pig", wordProposer.proposeWord());
    }
}
