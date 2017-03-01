package piglatin;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PigLatinTranslator plt = new PigLatinTranslator();
        System.out.println("Enter english phrase to translate: ");
        while (true) {
            String src = System.console().readLine();
            if (src.isEmpty()) {
                break;
            }
            System.out.println(plt.translate(src));
        }
    }
}
