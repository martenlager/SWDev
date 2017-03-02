package piglatin;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        PigLatinTranslator plt = new PigLatinTranslator();
        ProposeWord pw = new ProposeWord();
        
        System.out.println("Translate " + pw.proposeWord(1) + " to pigLatin:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String src = reader.readLine();
            if (src.isEmpty()) {
                break;
            }
            System.out.println(plt.translate(src));
        }
    }
}
