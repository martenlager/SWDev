package piglatin;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
    This test class checks that the scoring involved in the tutorial remains correct.
*/
public class TutorialTest {

    @Test 
    public void testScores() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
            TutorialTest.class.getResourceAsStream("tutorial")));
        String line;
        while((line = reader.readLine()) != null) {
            if (line.charAt(0) == '+') {
                String f[] = line.substring(1).split(":");
                int value = Integer.parseInt(f[0]);
                Score score = new Score();
                PigLatinSentenceTranslator plt = new PigLatinSentenceTranslator();
                String correct = plt.translateSentence(f[1]);
                assertEquals(value, score.score(correct, correct));
            }
        }
    }
}
