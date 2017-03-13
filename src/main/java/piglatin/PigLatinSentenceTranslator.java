package piglatin;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatinSentenceTranslator {
    String translateSentence(String src) {
        String translation = Arrays.stream(src.split("[^\\p{Alpha}'`]"))
                .map(new PigLatinTranslator()::translate)
                .collect(Collectors.joining(" "));
        if (Pattern.matches(".*?\\p{P}$", src)) {
            // Matches anything followed by a punctuation character
            return translation + src.charAt(src.length() - 1);
        }
        return translation;
    }
}
