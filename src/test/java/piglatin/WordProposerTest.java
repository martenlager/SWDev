package piglatin;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WordProposerTest {

	
    private final List<String> alternatives = Arrays.asList(
            "pig", "latin", "banana", "cheers", "eat", "wordMissing", "Pig latin banana cheers." , "Pig latin banana cheers eat.");
    private final WordProposer wordProposer = new WordProposer(alternatives, new Random());

    @Test
    public void testIfDifficultyIsIncreasing() {
    	int difficulty = 0;
    	for(int i = 0; i<wordProposer.getDictionarySize();i++){
    		assertEquals(true, difficulty <= wordProposer.proposeWord().length());
    		difficulty = wordProposer.proposeWord().length();
    	}
    }
    
    @Test
    public void testIfNotCrashingWhenGoingOverMaxNumbers() {
    	for(int i = 0; i<wordProposer.getDictionarySize()+10;i++){
    		wordProposer.proposeWord().length();
    	}
    	assertNotNull(wordProposer.proposeWord());
    }
    
    @Test
    public void checkIfNotNull() {
    	assertNotNull(wordProposer.proposeWord());
    }

    @Test
    public void proposeWordDeterministic() {
        WordProposer p = new WordProposer(alternatives, new Random(0));
        WordProposer s = new WordProposer(alternatives, new Random(0));
        assertEquals(p.proposeWord(), s.proposeWord());
        assertEquals(p.proposeWord(), s.proposeWord());
        assertEquals(p.proposeWord(), s.proposeWord());
    }

}
