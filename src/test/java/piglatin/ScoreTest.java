package piglatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {
    // Test correct answer of single word
    @Test
    public void correctWord() {
        Score score = new Score();
        assertEquals(1, score.score("Ellohay", "Ellohay"));
    }

    // Test incorrect answer of single word 
    @Test
    public void incorrectWord() {
        Score score = new Score();
        assertEquals(0, score.score("Ellohay", "Helloay"));
    }

    // Test that case sensitivity works
    @Test
    public void incorrectCase() {
        Score score = new Score();
        assertEquals(0, score.score("Ellohay", "ellohay"));
        assertEquals(0, score.score("Ellohay", "ElLohay"));
    }

    // Test that things don't break on empty input
    @Test
    public void emptyInput() {
        Score score = new Score();
        assertEquals(0, score.score("Ellohay", ""));
        assertEquals(0, score.score("Ellohay", null));
    }

    // Empty solution is a bug
    @Test(expected = NullPointerException.class)
    public void nullSolution() {
        Score score = new Score();
        assertEquals(0, score.score(null, ""));
    }

    // Test that the score accumulates in the class on repeated scoring requests
    @Test
    public void accumulate() {
        Score score = new Score();
        assertEquals(0, score.getScore());
        assertEquals(1, score.score("a", "a"));
        assertEquals(1, score.score("b", "b"));
        assertEquals(1, score.score("c", "c"));
        assertEquals(0, score.score("d", "a"));
        assertEquals(3, score.getScore());
    }
}
