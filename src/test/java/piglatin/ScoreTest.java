package piglatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {
    // Test correct answer of single word
    @Test
    public void correctWord() {
        Score score = new Score();
        assert(score.score("Ellohay", "Ellohay") == 1);
    }
   
    // Test incorrect answer of single word 
    @Test
    public void incorrectWord() {
        Score score = new Score();
        assert(score.score("Ellohay", "Helloay") == 0);
    }

    // Test that case sensitivity works
    @Test
    public void incorrectCase() {
        Score score = new Score();
        assert(score.score("Ellohay", "ellohay") == 0);
        assert(score.score("Ellohay", "ElLohay") == 0);
    }

    // Test that things don't break on empty input
    @Test
    public void emptyInput() {
        Score score = new Score();
        assert(score.score("Ellohay", "") == 0);
        assert(score.score("Ellohay", null) == 0);
    }

    // Empty solution is a bug
    @Test(expected=NullPointerException.class)
    public void nullSolution() {
        Score score = new Score();
        assert(score.score(null, "") == 0);
    }

    // Test that the score accumulates in the class on repeated scoring requests
    @Test
    public void accumulate() {
      Score score = new Score();
      assert(score.getScore() == 0);
      assert(score.score("a", "a") == 1);
      assert(score.score("b", "b") == 1);
      assert(score.score("c", "c") == 1);
      assert(score.score("d", "a") == 0);
      assert(score.getScore() == 3);
    }
  
}
