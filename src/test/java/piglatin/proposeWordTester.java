package piglatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class proposeWordTester {
    @Test
    public void proposeWord1() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("pig", wordProposer.proposeWord(1));
    }
    
    @Test
    public void proposeWord2() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("latin", wordProposer.proposeWord(2));
    }
    
    @Test
    public void proposeWord3() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("banana", wordProposer.proposeWord(3));
    }
    
    @Test
    public void proposeWord4() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("cheers", wordProposer.proposeWord(4));
    }
    
    @Test
    public void proposeWord5() {
        ProposeWord wordProposer = new ProposeWord();
        assertEquals("eat", wordProposer.proposeWord(5));
    }

}
