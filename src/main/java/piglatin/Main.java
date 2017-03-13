package piglatin;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {

    private static final long GAME_TIME = 5 * 60 * 1000;

    public static void main(String[] args) throws IOException {
        Tutorial.run();

        Score score = new Score();
        PigLatinSentenceTranslator plt = new PigLatinSentenceTranslator();

        List<String> alternatives = new SentenceReader().readFortunes();
        WordProposer pw = new WordProposer(alternatives, new Random());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long start = System.currentTimeMillis();
        System.out.println("Running pig latin translator game for 5 minutes.");
        while (System.currentTimeMillis() - start < GAME_TIME) {
            String wordToTranslate = pw.proposeWord();
            System.out.println("Translate '" + wordToTranslate + "' to pig latin:");

            String src = reader.readLine();
            if (src.isEmpty()) {
                break;
            }
            String solution = plt.translateSentence(wordToTranslate);

            System.out.println("Correct translation: " + solution);
            System.out.println("Score this translation: " + score.score(solution, src));
            System.out.println("Your total score: " + score.getScore());
        }
        System.out.println("Time out reached");
        System.out.println("Final score: " + score.getScore());
    }
}
