package piglatin;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Score score = new Score();
        PigLatinTranslator plt = new PigLatinTranslator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter english phrase to translate: ");
            String src = reader.readLine();
            if (src.isEmpty()) {
                break;
            }
            String answer = plt.translate(src);
            String solution = plt.translate(src);
            System.out.println("Correct translation: " + solution);
            System.out.println("Score this translation: " + score.score(solution, answer));
            System.out.println("Your total score: " + score.getScore());
            
        }
    }
}
