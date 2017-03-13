package piglatin;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

class Tutorial {
    /**
    * Takes over until the user exits the tutorial
    */
    public static void run() throws IOException {
        showWelcome();

        String input;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("Would you like to run the tutorial (y/n): ");
        } while((input = reader.readLine()) != null && !(input.equalsIgnoreCase("y") ||
            input.equalsIgnoreCase("n")));

        if (input.equalsIgnoreCase("y")) {
            System.out.println();
            runTutorial();
            System.out.println("[Press enter]");
            reader.readLine();
        } 
        System.out.println();
    }

    static BufferedReader getReader(String resource) throws IOException {
        return new BufferedReader(new InputStreamReader(Tutorial.class.getResourceAsStream(resource)));
    }

    static void streamToConsole(String resource) throws IOException {
        getReader(resource).lines().forEach(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
            public Consumer andThen(Consumer after) { throw new Error("Not implemented"); }
        });
    }

    static void tryIt(int expectedScore, String str) {
        try {
            Score score = new Score();
            PigLatinSentenceTranslator plt = new PigLatinSentenceTranslator();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String solution = plt.translateSentence(str);

            System.out.println();
            System.out.print("Try it now, translate '"+str+"' to Pig Latin: ");
            String answer = reader.readLine();
            System.out.println();
            if (expectedScore == score.score(solution, answer)) {
                System.out.println("That is correct!");
            } else {
                System.out.println("That was incorrect, the correct answer is: " + solution);
            }
            System.out.println("[Press enter]");
            reader.readLine();
        } catch(IOException e) { e.printStackTrace(); }
    }

    public static void showWelcome() throws IOException {
        streamToConsole("welcome.txt");
    }

    public static void runTutorial() throws IOException {
        getReader("tutorial").lines().forEach(new Consumer<String>() {
            public void accept(String s) {
                if (s.charAt(0) == '+') {
                    String f[] = s.substring(1).split(":");
                    tryIt(Integer.parseInt(f[0]), f[1]);
                } else {
                    System.out.println(s);
                }
            }
            public Consumer andThen(Consumer after) { throw new Error("Not implemented"); }
        });
    }


}
