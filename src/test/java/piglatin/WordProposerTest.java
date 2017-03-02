package piglatin;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class WordProposerTest {
    private final List<String> alternatives = Arrays.asList(
            "pig", "latin", "banana", "cheers", "eat", "wordMissing");
    private final WordProposer wordProposer = new WordProposer(alternatives, new Random());

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
    public void getWord6() {
        assertEquals("wordMissing", wordProposer.getWord(5));
    }

    @Test
    public void dictionarySize() {
        WordProposer p = new WordProposer(alternatives, new Random());
        assert(p.getDictionarySize() == alternatives.size());
    }

    @Test
    public void proposeWord() {
        Random random1 = new Random(0);
        Random random2 = new Random(0);
        WordProposer p = new WordProposer(alternatives, random1);
        int s = p.getDictionarySize();
        int x = random2.nextInt(s);
        assertEquals(p.getWord(x), p.proposeWord());
        x = random2.nextInt(s);
        assertEquals(p.getWord(x), p.proposeWord());
        x = random2.nextInt(s);
        assertEquals(p.getWord(x), p.proposeWord());
    }

    @Test
    public void wrapAround() {
        assertEquals("wordMissing", wordProposer.getWord(6));
    }
}
