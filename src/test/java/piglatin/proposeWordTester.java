package piglatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class proposeWordTester {
    @Test
    public void getWord1() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("pig", wordProposer.getWord(1));
    }
    
    @Test
    public void getWord2() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("latin", wordProposer.getWord(2));
    }
    
    @Test
    public void getWord3() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("banana", wordProposer.getWord(3));
    }
    
    @Test
    public void getWord4() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("cheers", wordProposer.getWord(4));
    }
    
    @Test
    public void getWord5() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("eat", wordProposer.getWord(5));
    }

    @Test
    public void proposeWord() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("pig", wordProposer.proposeWord());
        assertEquals("latin", wordProposer.proposeWord());
        assertEquals("banana", wordProposer.proposeWord());
        assertEquals("cheers", wordProposer.proposeWord());
        assertEquals("eat", wordProposer.proposeWord());
        assertEquals("pig", wordProposer.proposeWord());
    }

}
