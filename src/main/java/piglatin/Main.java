package piglatin;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Score score = new Score();
        PigLatinTranslator plt = new PigLatinTranslator();

        List<String> alternatives = new SentenceReader().readFortunes();
        WordProposer pw = new WordProposer(alternatives);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        while (true) {
        	String wordToTranslate = pw.proposeWord(index++);
        	System.out.println("Translate '" + wordToTranslate + "' to pigLatin:");
        	
        	String src = reader.readLine();
            if (src.isEmpty()) {
                break;
            }
        	
        	String answer = src;
            String solution = plt.translate(wordToTranslate);
            System.out.println("Correct translation: " + solution);
            System.out.println("Score this translation: " + score.score(solution, answer));
            System.out.println("Your total score: " + score.getScore());
            
        }
    }
}
